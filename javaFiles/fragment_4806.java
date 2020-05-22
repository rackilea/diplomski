import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();

        Foo person = mapper.readValue(jsonFile, Foo.class);
        System.out.println(person);
    }
}

class BigDecimal2JsonDeserializer extends NumberDeserializers.BigDecimalDeserializer {

    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        BigDecimal value = super.deserialize(p, ctxt);

        // set scale
        value = value.setScale(2, BigDecimal.ROUND_HALF_EVEN);

        return value;
    }
}

class Foo {

    @JsonDeserialize(using = BigDecimal2JsonDeserializer.class)
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "amount=" + amount +
                '}';
    }
}