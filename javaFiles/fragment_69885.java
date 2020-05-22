import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.data.util.Pair;

/**
 * Created by yprajapati on 19/09/2019.
 */

public @Data
class Test {

    private long date;

    @JsonSerialize(using = DateSerializerCustom.class)
    private Pair formattedDate;

    public Pair getFormattedDate() {
        return Pair.of(date, "yyyy-MM-dd HH:mm"); // Here you can add your desired date format
    }
}