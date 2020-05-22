import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

public class FXWebViewInSwing {

    private JFXPanel jfxPanel ;

    public void createAndShowWindow() {
        JFrame frame = new JFrame();
        JButton quit = new JButton("Quit");
        quit.addActionListener(event -> System.exit(0));
        jfxPanel = new JFXPanel();
        Platform.runLater(this::createJFXContent);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(quit);

        frame.add(BorderLayout.CENTER, jfxPanel);
        frame.add(BorderLayout.SOUTH, buttonPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,  800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createJFXContent() {
        WebView webView = new WebView();
        webView.getEngine().load("http://stackoverflow.com/questions/42297864/javafx-webview-in-java-project");
        Scene scene = new Scene(webView);
        jfxPanel.setScene(scene);
    }

    public static void main(String[] args) {
        FXWebViewInSwing swingApp = new FXWebViewInSwing();
        SwingUtilities.invokeLater(swingApp::createAndShowWindow);
    }
}