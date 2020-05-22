import javax.swing.*;
import java.net.URL;

class ShowHtml {

    public static void main(String[] args) {
        final String address =
            "jar:http://pscode.org/jh/hs/object.jar!/popup_contents.html";
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    URL url = new URL(address);
                    JEditorPane jep = new JEditorPane(url);
                    JFrame f = new JFrame("Show HTML in Jar");
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.add(new JScrollPane(jep));
                    f.pack();
                    f.setSize(400,300);
                    f.setLocationByPlatform(true);
                    f.setVisible(true);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}