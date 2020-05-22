import org.joda.time.DateTimeZone;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TZRule extends TestWatcher {

    private DateTimeZone origDefault = DateTimeZone.getDefault();

    private DateTimeZone tz;

    public TZRule( DateTimeZone tz ) {
        this.tz = tz;
    }

    @Override
    protected void starting( Description description ) {
        DateTimeZone.setDefault( tz );
    }

    @Override
    protected void finished( Description description ) {
        DateTimeZone.setDefault( origDefault );
    }
}