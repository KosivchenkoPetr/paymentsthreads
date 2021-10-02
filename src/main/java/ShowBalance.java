


public class ShowBalance implements Runnable {
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
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                current.interrupt();
            }
        }
    }

}
