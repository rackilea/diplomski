package <your package here>;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.data.JRXmlDataSource;

public class MyXmlDataSource extends JRXmlDataSource {

    public MyXmlDataSource(String x, String y) throws JRException
    {
        super(x,y);
    }

    public Object getFieldValue(JRField jrField) throws JRException {
        Object ret = super.getFieldValue(jrField);
        System.out.println(ret);
        return ret;
    }
}