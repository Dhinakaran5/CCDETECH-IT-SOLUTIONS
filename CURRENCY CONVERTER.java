import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static final Map<String, String> CURRENCY_NAMES = new HashMap<>();
    private static final Map<String, Double> EXCHANGE_RATES = new HashMap<>();

    static {
        // Initialize currency names
        CURRENCY_NAMES.put("USD", "United States Dollar");
        CURRENCY_NAMES.put("EUR", "Euro");
        CURRENCY_NAMES.put("GBP", "British Pound");
        CURRENCY_NAMES.put("JPY", "Japanese Yen");
        CURRENCY_NAMES.put("CAD", "Canadian Dollar");
        CURRENCY_NAMES.put("AUD", "Australian Dollar");
        CURRENCY_NAMES.put("CHF", "Swiss Franc");
        CURRENCY_NAMES.put("CNY", "Chinese Yuan");
        CURRENCY_NAMES.put("SEK", "Swedish Krona");
        CURRENCY_NAMES.put("NZD", "New Zealand Dollar");
        CURRENCY_NAMES.put("NOK", "Norwegian Krone");
        CURRENCY_NAMES.put("SGD", "Singapore Dollar");
        CURRENCY_NAMES.put("KRW", "South Korean Won");
        CURRENCY_NAMES.put("TRY", "Turkish Lira");
        CURRENCY_NAMES.put("INR", "Indian Rupee");
        CURRENCY_NAMES.put("BRL", "Brazilian Real");
        CURRENCY_NAMES.put("ZAR", "South African Rand");
        CURRENCY_NAMES.put("RUB", "Russian Ruble");
        CURRENCY_NAMES.put("MXN", "Mexican Peso");
        CURRENCY_NAMES.put("HKD", "Hong Kong Dollar");

        // Initialize exchange rates (simplified for demonstration purposes)
        EXCHANGE_RATES.put("USD", 1.0);
        EXCHANGE_RATES.put("EUR", 0.85);
        EXCHANGE_RATES.put("GBP", 0.73);
        EXCHANGE_RATES.put("JPY", 112.20);
        EXCHANGE_RATES.put("CAD", 1.26);
        EXCHANGE_RATES.put("AUD", 1.32);
        EXCHANGE_RATES.put("CHF", 0.92);
        EXCHANGE_RATES.put("CNY", 6.46);
        EXCHANGE_RATES.put("SEK", 8.74);
        EXCHANGE_RATES.put("NZD", 1.41);
        EXCHANGE_RATES.put("NOK", 8.79);
        EXCHANGE_RATES.put("SGD", 1.34);
        EXCHANGE_RATES.put("KRW", 1182.20);
        EXCHANGE_RATES.put("TRY", 13.42);
        EXCHANGE_RATES.put("INR", 75.44);
        EXCHANGE_RATES.put("BRL", 5.42);
        EXCHANGE_RATES.put("ZAR", 16.75);
        EXCHANGE_RATES.put("RUB", 72.54);
        EXCHANGE_RATES.put("MXN", 20.19);
        EXCHANGE_RATES.put("HKD", 7.77);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display available currencies
        displayCurrencies();

        // Input: Allow the user to choose the base and target currencies
        System.out.print("Enter the base currency code: ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency code: ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Amount Input: Take input from the user
        System.out.print("Enter the amount to convert: ");
        double amountToConvert = scanner.nextDouble();

        // Fetch exchange rates
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        if (exchangeRate == -1) {
            System.out.println("Error fetching exchange rates. Please try again later.");
        } else {
            // Currency Conversion
            double convertedAmount = amountToConvert * exchangeRate;

            // Display Result
            System.out.println("\nConversion Result:");
            System.out.println(amountToConvert + " " + baseCurrency + " is equal to " + convertedAmount + " " + targetCurrency);
        }

        scanner.close();
    }

    private static void displayCurrencies() {
        System.out.println("Available Currencies:");
        for (Map.Entry<String, String> entry : CURRENCY_NAMES.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        // Replace this with actual API call to fetch real-time exchange rates
        // In a real-world scenario, you would use a currency exchange API
        if (EXCHANGE_RATES.containsKey(baseCurrency) && EXCHANGE_RATES.containsKey(targetCurrency)) {
            return EXCHANGE_RATES.get(targetCurrency) / EXCHANGE_RATES.get(baseCurrency);
        } else {
            // Return -1 to indicate an error in fetching exchange rates
            return -1;
        }
    }
}
