package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class App extends JFrame {

    private static final long serialVersionUID = 1L;

    private String HTML = "<html><table border=\"1\"><tr><td><a href=\"#row001\">First row</a></td></tr><tr><td><a href=\"#row002\">Second row</a></td></tr><tr><td><a href=\"#row003\">Third row</a></td></tr></table></html>";

    private JPanel contentPane;
    private JEditorPane editor;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App frame = new App();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public App() {
        setTitle("HTML TABLE CLICKABLE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 408, 235);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        editor = new JEditorPane();
        editor.setEditable(false);
        editor.setContentType("text/html");
        contentPane.add(editor, BorderLayout.CENTER);
        editor.setText(HTML);

        editor.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    String rowcode = e.getDescription();
                    int row = Integer.parseInt(rowcode.replace("#row",""));

                    System.out.println(row);
                }
            }

        });

    }
}