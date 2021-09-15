import java.math.BigDecimal;

public class CurrencyConversion {

    public String getCurrencyConversion(String k, int v, BigDecimal currencyRate) {

        String valueInUSD = "";

        if (currencyRate != null) {
            BigDecimal c = BigDecimal.valueOf(v).multiply(currencyRate);
            valueInUSD = " (USD " + c + ")";
        }

        return valueInUSD;
    }
}
