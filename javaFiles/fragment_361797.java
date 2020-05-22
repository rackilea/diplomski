import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

// please change name of your own choice
Logger log = Logger.getLogger("CustomLogger"); 
log.setUseParentHandlers(false);
log.setLevel(Level.ALL);

FileHandler handler = new FileHandler("[log_file_location]");
handler.setFormatter(new CustomFormatter()); // set formatter
log.addHandler(handler);

log.info("test message");

handler.close(); // close the handler at some later point in your application.