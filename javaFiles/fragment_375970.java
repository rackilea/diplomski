import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class MediaPlayerInSwing {

    private static final String MEDIA_URL = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv" ;

    private JFrame window ;

    private JFXPanel jfxPanel ;
    private Media media ;
    private MediaPlayer player ;
    private MediaView mediaView ;
    private BorderPane root ;
    private Scene scene ;

    private Button button ;

    // create on AWT Event Dispatch Thread
    public MediaPlayerInSwing() {
        Platform.setImplicitExit(false);
        initGUI();
    }

    private void initGUI()  {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());

        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout());
        button = new Button("Show video");
        controls.add(button);
        button.addActionListener(e -> {
            if (jfxPanel == null) {
                showVideo();
            } else {
                tearDownVideo();
            }
        });

        window.add(controls, BorderLayout.SOUTH);
        window.setSize(600, 480);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private void showVideo() {


        jfxPanel = new JFXPanel();

        Platform.runLater(() -> {
            media = new Media(MEDIA_URL);
            player = new MediaPlayer(media);
            player.play(); 
            mediaView = new MediaView(player);
            root = new BorderPane(mediaView);
            scene = new Scene(root, 600, 400);
            jfxPanel.setScene(scene);
        });

        window.add(jfxPanel, BorderLayout.CENTER);
        button.setLabel("Hide video");
    }

    private void tearDownVideo() {

        window.remove(jfxPanel);

        Platform.runLater(() -> {
            player.stop();
            player.dispose();
            player = null ;
            mediaView = null ;
            root = null ;
            jfxPanel.setScene(null);
            scene = null ;
            SwingUtilities.invokeLater(() -> {
                jfxPanel = null ;
                // force window to repaint...
                window.getRootPane().repaint();
            });
        });
        button.setLabel("Show video");
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(MediaPlayerInSwing::new);
    }
}