import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<String,Integer> balance = new HashMap<>();

    public static void main(String[] args) {
        String accountOperation = "";
        String[] subStr;

        //new ShowBalance("ShowBalance").start();

        Runnable showBalance = () -> {
          do {
                try {
                    Main.balance.forEach((k, v) -> {
                        if (v != 0) {
                            System.out.format("Остаток в валюте: %s, сумма: %d%n", k, v);
                        }
                    });
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    //System.out.println("Thread has been interrupted");
                }

            } while (true);

        };

        Thread threadShowBalance = new Thread(showBalance);
        threadShowBalance.start();

        Scanner scanner = new Scanner(System.in);
        while((accountOperation = scanner.nextLine()) != "stop"){
            threadShowBalance.interrupt();
            if(accountOperation.equals("stop")){
                threadShowBalance.interrupt();
                break;
            }else{
                String delimeter = " "; // Разделитель
                subStr = accountOperation.split(delimeter);

                // +++ Проверки на корректность
                boolean corr = true;
                int value = 0;
                if (subStr.length!=2){
                    System.out.println("В строке должно быть два слова");
                    corr = false;
                 }

                try {
                    value = Integer.parseInt(subStr[1]);
                }catch (NumberFormatException o) {
                    System.out.println("введена некорректная сумма");
                    corr = false;
                }
                // --- Проверки на корректность

                if (corr) {
                    //добавление значения
                    String key = subStr[0];
                    //int value = Integer.parseInt(subStr[1]);
                    addBalance(key, value);
                }
            }
        }
        threadShowBalance.interrupt();
    }

    public static void showBalance(){
        balance.forEach((k, v) -> {
          if (v!=0) {
              System.out.format("Остаток в валюте: %s, сумма: %d%n", k, v);
          }
        });
    }

    public static void addBalance(String key, Integer value) {
        if (!balance.containsKey(key)) {
            balance.put(key, value);
        } else {
            balance.put(key, balance.get(key) + value);
        }
    }

}
