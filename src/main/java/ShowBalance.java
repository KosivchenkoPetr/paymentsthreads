

import java.util.TimerTask;

public class ShowBalance extends TimerTask {
    public void run() {

        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
            try {
                Main.balance.forEach((k, v) -> {
                    if (v != 0) {
                        String valueInUSD = new CurrencyConversion().getCurrencyConversion(k, v, Main.usdCurrency.get(k));
                        System.out.println(new FormattedBalance().getFormattedBalance(k, v, valueInUSD));
                    }
                });
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                current.interrupt();
            }
        }
    }

}
