import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Item>> typeReference = new TypeReference<List<Item>>() {
        };
        List<Item> readValue = mapper.readValue(jsonFile, typeReference);
        System.out.println(readValue);

    }
}

class DifferentFormatsDateJsonDeserializer extends JsonDeserializer<Date> {

    private DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateTimeFormatter yearMonthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");


    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        try {
            if (value.length() == 7) {
                YearMonth yearMonth = YearMonth.parse(value, yearMonthFormatter);
                return convertToDateViaInstant(yearMonth.atDay(1));
            } else {
                LocalDate localDate = LocalDate.parse(value, localDateFormatter);
                return convertToDateViaInstant(localDate);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Date convertToDateViaInstant(LocalDate dateToConvert) {
        return Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
}

class Item {

    @JsonDeserialize(using = DifferentFormatsDateJsonDeserializer.class)
    private Date publishedDate;

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "publishedDate=" + publishedDate +
                '}';
    }
}