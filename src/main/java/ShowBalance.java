


public class ShowBalance implements Runnable {
    private final CurrencyConversion currencyConversion = new CurrencyConversion();
    private final FormattedBalance formattedBalance = new FormattedBalance();

    public synchronized void run() {

        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
            try {
                Main.balance.forEach((k, v) -> {
                    if (v != 0) {
                        String valueInUSD = currencyConversion.getCurrencyConversion(k, v, Main.usdCurrency.get(k));
                        System.out.println(formattedBalance.getFormattedBalance(k, v, valueInUSD));
                    }
                });
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                current.interrupt();
            }
        }
    }

}
