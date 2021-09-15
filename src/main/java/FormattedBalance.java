public class FormattedBalance {


    public String getFormattedBalance(String k, int v, String valueInUSD) {

        return String.format("Остаток в валюте : %s, сумма: %d%s", k, v, valueInUSD);

    }
}
