import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.zalando.jackson.datatype.money.MoneyModule;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

public class JsonMoneyApp {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new MoneyModule());

        CurrencyUnit cu = Monetary.getCurrency("USD");
        String json = mapper.writeValueAsString(cu);
        System.out.println(json);

        CurrencyUnit unit = mapper.readValue(json, CurrencyUnit.class);
        System.out.println(unit);
    }
}