import java.text.SimpleDateFormat;
import java.util.Date;

...

Date today = new Date();
Date predefined = new SimpleDateFormat("yyyy-MM-dd").parse("2011-01-01");

if(today.equals(predefined)) {
    ...
}