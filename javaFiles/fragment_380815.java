import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TextHelper {
    private static ScriptEngine engine = new ScriptEngineManager()
        .getEngineByName("JavaScript");

/**
 * Encoding if need escaping %$&+,/:;=?@<>#%
 *
 * @param str should be encoded
 * @return encoded Result 
 */
public static String escapeJavascript(String str) {
    try {
        return engine.eval(String.format("escape(\"%s\")", 
            str.replaceAll("%20", " "))).toString()
                .replaceAll("%3A", ":")
                .replaceAll("%2F", "/")
                .replaceAll("%3B", ";")
                .replaceAll("%40", "@")
                .replaceAll("%3C", "<")
                .replaceAll("%3E", ">")
                .replaceAll("%3D", "=")
                .replaceAll("%26", "&")
                .replaceAll("%25", "%")
                .replaceAll("%24", "$")
                .replaceAll("%23", "#")
                .replaceAll("%2B", "+")
                .replaceAll("%2C", ",")
                .replaceAll("%3F", "?");
    } catch (ScriptException ex) {
        Logger.getLogger(TextHelper.class.getName())
            .log(Level.SEVERE, null, ex);
        return null;
    }
}