import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static HashMap<String, Integer> balance = new HashMap<>();
    public static HashMap<String, BigDecimal> usdCurrency = new HashMap<>();
    public static Thread threadShowBalance;

    public static void main(String[] args) {

        getUsdCurrency(); //fill HashMap usdCurrency

        readStartBalance(); //reading start balance from txt file

        startSowBalanceThread(); //start thread with periodical balance show

        consoleReading(); //read data from console

    }


    public static void addBalance(String str) {
        String[] strArray = str.split(" ");
        boolean corr = true;
        int value = 0;
        if (strArray.length != 2) {
            System.out.println("В строке " + str + " должно быть два слова");
            corr = false;
        }
        try {
            value = Integer.parseInt(strArray[1]);
        } catch (NumberFormatException o) {
            System.out.println("В строке " + str + " содержится некорректная сумма");
            corr = false;
        } catch (ArrayIndexOutOfBoundsException o) {
            System.out.println("В строке " + str + " должно быть два слова");
            corr = false;
        }
        String key = strArray[0];
        if (corr) {
            if (!balance.containsKey(key)) {
                balance.put(key, value);
            } else {
                balance.put(key, balance.get(key) + value);
            }
        }
    }

    public static void readStartBalance() {
        System.out.println("Enter file path with start balance");
        System.out.println("Enter \"0\" to skip file loading");
        System.out.println("Enter \"1\" to load test file");

        Scanner in = new Scanner(System.in);
        String filename = in.nextLine();

        if (filename.equals("0")) //nothing to do
            System.out.println("File loading skipped");
        else {
            if (filename.equals("1")) {
                filename = "startBalance.txt";
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                    addBalance(line);
                }
            } catch (FileNotFoundException f) {
                System.out.println(filename + " does not exist, file not loaded");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void startSowBalanceThread() {
        ShowBalance showBalance = new ShowBalance();
        threadShowBalance = new Thread(showBalance);
        threadShowBalance.start();
    }

    public static void consoleReading() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String accountOperation = scanner.nextLine().toUpperCase(Locale.ROOT); //"USD" and "usd" must be the same
            if (accountOperation.equals("QUIT")) {
                System.out.println("Работа программы завершена по команде пользователя");
                threadShowBalance.interrupt();
                break;
            } else {
                addBalance(accountOperation);
            }
        }
    }

    public static void getUsdCurrency() {
        usdCurrency.put("HKD", BigDecimal.valueOf(0.13));
        usdCurrency.put("RMB", BigDecimal.valueOf(0.16));
    }
}
