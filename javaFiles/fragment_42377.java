import org.apache.poi.hsmf.MAPIMessage;

public class PoiMsgMime {

    public String getMessageMime(String fileName) {
        try {
            new MAPIMessage(fileName);
            return "application/vnd.ms-outlook";
        } catch (Exception e) {
            return null;
        }
    }
}