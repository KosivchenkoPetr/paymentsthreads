import java.math.BigDecimal;
import java.math.RoundingMode;

public class ShowBalance implements Runnable {
    public void run() {

        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
            try {
                Main.balance.forEach((k, v) -> {
                    if (v != 0) {
                        String valueInUSD = "";
                        BigDecimal get = Main.usdCurrency.get(k);
                        if (get != null) {
                            BigDecimal c = BigDecimal.valueOf(v).multiply(new BigDecimal(String.valueOf(get)));
                            valueInUSD = " (USD " + c + ")";
                        }
                        System.out.format("Остаток в валюте : %s, сумма: %d%s%n", k, v, valueInUSD);
                    }
                });
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                current.interrupt();
            }
        }
    }
}
