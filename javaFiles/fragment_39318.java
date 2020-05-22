import org.apache.log4j.DefaultThrowableRenderer;
import org.apache.log4j.spi.ThrowableRenderer;

public class LogThrowableRenderer implements ThrowableRenderer {

    DefaultThrowableRenderer def = new DefaultThrowableRenderer();

    @Override
    public String[] doRender(Throwable t) {
        String[] temp = def.doRender(t);
        for (int i = 0; i < temp.length; i++) {
            temp[i] = "myPrefix "+temp[i];
        }
        return temp;
    }

}