import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./src/main/resources/test.json");

        ObjectMapper mapper = new ObjectMapper();

        Currency currency = mapper.readValue(jsonFile, Currency.class);
        System.out.println(currency + " => " + currency.getRates());
    }
}

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum Currency {

    USD("USD", "United States Dollar"),
    EUR("EUR", "Euro"),
    BGP("BGP", "British Pound"),
    AUD("AUD", "Australian Dollar"),
    CAD("CAD", "Canadian Dollar");

    private final String shortName;
    private final String fullName;
    private Map<Enum, Double> rates;

    Currency(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.rates = Collections.emptyMap();
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public Map<Enum, Double> getRates() {
        return rates;
    }

    public static Currency fromShortName(String value) {
        for (Currency currency : values()) {
            if (currency.getShortName().equals(value)) {
                return currency;
            }
        }

        throw new IllegalArgumentException(value + " is not found!");
    }

    @JsonCreator
    public static Currency from(Map<String, Object> value) {
        String shortName = value.getOrDefault("shortName", "").toString();
        Currency currency = fromShortName(shortName);

        Map<String, Double> rates = (Map<String, Double>) value.getOrDefault("rates", Collections.emptyMap());
        Map<Enum, Double> newRates = new HashMap<>(9);
        rates.forEach((k, v) -> {
            newRates.put(Currency.fromShortName(k), v);
        });

        currency.rates = Collections.unmodifiableMap(newRates);
        return currency;
    }
}