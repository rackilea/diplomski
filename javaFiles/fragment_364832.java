import java.awt.*;
import javax.swing.*;

public class MalayalamSSCCE {

    public static final String malluString = "\u0d0e\u0d23\u0d4d\u200d\u0d2a\u0d24\u0d4d\u0d24\u0d47\u0d34\u0d41\u0d32\u0d15??\u0d4d\u0d37\u0d24\u0d4d\u0d24\u0d3f \u0d05\u0d31\u0d41\u0d2a\u0d24\u0d4d\u0d24\u0d2f\u0d4d\u0d2f\u0d3e\u0d2f\u0d3f\u0d30\u0d24\u0d4d\u0d24\u0d3f \u0d28\u0d3e\u0d28\u0d4d\u0d28\u0d42\u0d31\u0d4d\u0d31\u0d3f\u0d2e\u0d41\u0d2a\u0d4d\u0d2a\u0d24\u0d4d\u0d24\u0d3f\u0d30\u0d23\u0d4d\u0d1f\u0d41";

    public static Font getFirstFontThatCanDisplay(String text) {
        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNameArray = ge.getAvailableFontFamilyNames();
        for (String name : fontNameArray) {
            Font f = new Font(name, Font.PLAIN, 20);
            if (f.canDisplayUpTo(text)<0) return f;
        }
        return null;
    }

    public static void main(String[] args) {
        Font f = getFirstFontThatCanDisplay(malluString);
        System.out.println(f);

        JLabel l = new JLabel(malluString);
        l.setFont(f);

        JOptionPane.showMessageDialog(null, l);
    }
}