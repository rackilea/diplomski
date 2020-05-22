import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.pattern.ClassicConverter ;
import java.util.concurrent.atomic.AtomicLong;

public class LocalSequenceNumberConverter extends ClassicConverter {

  AtomicLong sequenceNumber = new AtomicLong(0);

  @Override
  public String convert(ILoggingEvent event) {
    return Long.toString(sequenceNumber.getAndIncrement());
  }
}