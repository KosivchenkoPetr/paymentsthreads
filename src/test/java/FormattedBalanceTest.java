import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormattedBalanceTest {

    @Test
    void getFormattedBalance() {
        testWithCurrency();
        testWithoutCurrency();
    }

    private void testWithCurrency() {

        String expectedStr = "Остаток в валюте : HKD, сумма: 1000 (USD 130.00)";
        String balanceStr = new FormattedBalance().getFormattedBalance("HKD", 1000, " (USD 130.00)");
        assertEquals(expectedStr, balanceStr);

    }

    private void testWithoutCurrency() {

        String expectedStr = "Остаток в валюте : USD, сумма: 1000";
        String balanceStr = new FormattedBalance().getFormattedBalance("USD", 1000, "");
        assertEquals(expectedStr, balanceStr);

    }

}