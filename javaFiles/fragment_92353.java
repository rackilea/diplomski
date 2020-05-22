import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatTest {

    @Test(expected = ParseException.class)
    public void testSetLenient_IncorrectDateInput() throws ParseException {
        // setup
        String input = "2023/03/22";
        String pattern = "MM/dd/yyyy";
        DateFormat format = new SimpleDateFormat(pattern);
        format.setLenient(false);
        // exercise and assert
        format.parse(input);
    }
}