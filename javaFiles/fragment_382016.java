import com.sun.javafx.application.PlatformImpl;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class browser extends JFrame implements HyperlinkListener {

    URL pageURL;
    private static final long serialVersionUID = 1630568393141656837L;
    JPanel panel;
    JButton back, forward, go;
    JTextField website;
    JScrollPane sp;
    private JFXPanel display;

    WebView webComponent;

    public void setPanel() {
        panel = new JPanel();
        back = new JButton("<<");
        forward = new JButton(">>");
        go = new JButton("GO");
        panel.add(back);
        panel.add(forward);
        website = new JTextField("http://", 10);
        panel.add(website);
        panel.add(go);

        display = new JFXPanel();
        createScene();

        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        browse();
                    }
                });

            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(display, BorderLayout.CENTER);
        setSize(900, 500);
        setVisible(true);
    }

    private void createScene() {
        PlatformImpl.startup(new Runnable() {
            @Override
            public void run() {

                BorderPane borderPane = new BorderPane();
                webComponent = new WebView();
                borderPane.setCenter(webComponent);
                Scene scene = new Scene(borderPane, 450, 450);
                display.setScene(scene);

            }
        });
    }

    protected void browse() {
        String url = website.getText();
        if (url != null && url.length() > 0) {
            webComponent.getEngine().load(url);
        }
    }

    public static void main(String arg[]) {
        browser br = new browser();
        br.setPanel();
    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent arg0) {
        HyperlinkEvent.EventType event = arg0.getEventType();
        if (event == HyperlinkEvent.EventType.ACTIVATED);
        {
            browse();
        }
    }
}