import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConversionTest {

    @Test
    void getCurrencyConversion() {

        testConversionWithRate();
        testConversionWithoutRate();

    }


    private void testConversionWithRate() {

        String expectedStr = " (USD 130.00)";
        String conversionStr = new CurrencyConversion().getCurrencyConversion("HKD", 1000, BigDecimal.valueOf(0.13));
        assertEquals(expectedStr, conversionStr);
    }

    private void testConversionWithoutRate() {

        String expectedStr = "";
        String conversionStr = new CurrencyConversion().getCurrencyConversion("HKD", 1000, null);
        assertEquals(expectedStr, conversionStr);
    }
}