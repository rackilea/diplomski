import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.data.util.Pair;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by yprajapati on 19/09/2019.
 */

public class DateSerializerCustom extends JsonSerializer<Pair<Long, String>> {

    public void serialize(Pair<Long, String> pair, JsonGenerator jsonGen, SerializerProvider serProv) throws IOException {
        DateFormat sdf = new SimpleDateFormat(pair.getSecond());
        String formattedDate = sdf.format(pair.getFirst());
        jsonGen.writeString(formattedDate);
    }
}