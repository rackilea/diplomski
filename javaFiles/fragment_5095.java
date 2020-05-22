import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.FormSubmitEvent;
import javax.swing.text.html.HTMLEditorKit;

public class JavaApplication26 {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //create new instance of JFrame
                new Navigate();
            }
        });
    }
}

class Navigate {

    public Navigate() {
        initComponents();
    }

    private void initComponents() { //this is a constructor

        javax.swing.JFrame jf = new javax.swing.JFrame();
        jf.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setEditable(false);
        textPane.setText("<html>" + "<body>" + "<form action=\"#\">"
                + "<input name=\"input1\" type=\"text\" />"
                + "<input name=\"input2\" type=\"text\" /><br/>"
                + "<input name=\"cb1\" type=\"checkbox\" /><br/>"
                + "<input name=\"rb1\" type=\"radio\" /><br/>"
                + "<input type=\"submit\" value=\"go\" />" + "</form>"
                + "</body>" + "</html>");

        HTMLEditorKit kit = (HTMLEditorKit) textPane.getEditorKit();
        kit.setAutoFormSubmission(false);
        textPane.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e instanceof FormSubmitEvent) {
                    System.out.println(((FormSubmitEvent) e).getData());
                }
            }
        });

        //add components
        jf.getContentPane().setLayout(new BoxLayout(jf.getContentPane(), BoxLayout.Y_AXIS));
        jf.getContentPane().add(textPane);

        jf.pack();//pack
        jf.setVisible(true);
    }
}