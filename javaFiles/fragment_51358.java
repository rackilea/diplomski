import com.google.common.base.Strings;
import net.sf.jasperreports.engine.JRDefaultScriptlet;

public class SampleJRScriptlet extends JRDefaultScriptlet {

    public String doubleField(String value) {
        return Strings.repeat(value, 2);
    }
}