import java.sql.Timestamp;
import org.joda.time.DateTime;

Timestamp timestamp = new Timestamp(23423434);
DateTime datetime = new DateTime(timestamp).toString();
System.out.println(datetime.toString());