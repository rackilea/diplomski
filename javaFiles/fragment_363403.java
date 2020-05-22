import java.text.SimpleDateFormat;
import java.text.DateFormat;

final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

context.addInstallerEventListener(new InstallerEventListener() {
    public void installerEvent(InstallerEvent event) {
        if (event.getType() == EventType.BEFORE_EXECUTE_ACTION) {
            Util.logInfo(event.getSource(), "Started action at " + 
                dateFormat.format(new Date()));
        } else if (event.getType() == EventType.AFTER_EXECUTE_ACTION) {
            Util.logInfo(event.getSource(), "Finished action at " + 
                dateFormat.format(new Date()));
        }
    }
});