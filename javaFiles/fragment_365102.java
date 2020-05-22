import java.awt.Color;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.*;
import javafx.scene.text.*;
import javax.swing.*;

public class SwingJFXCombo {

    /**
     * The control who starts everything.
     * This should have the references you need.
     * Uses the singleton pattern
     */
    public static class MainController{

        //Top level fields we may need access too
        JFXPanel jfxPanel;
        JPanel jp;
        JFrame frame;

        //Doing singleton stuff
        private static MainController instance;
        public static MainController getInstance(){
            if(instance == null){
                instance = new MainController();
            }
            return instance;
        }

        private MainController(){
            jfxPanel = new JFXPanel();
            jp = new JPanel();

            jp.add(jfxPanel);
            jp.setVisible(true);
            jp.setBackground(Color.CYAN);

            //Setup to display swing stuff
            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.add(jp);
            frame.pack();
        }

        public static void initialize(){
            getInstance();

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    MainController mc = getInstance();
                    Scene scene = mc.initScene();
                    mc.jfxPanel.setScene(scene);
                }
            });
        }

        private Scene initScene(){
            Group  root  =  new  Group();
            Scene  scene  =  new  Scene(root, javafx.scene.paint.Color.ALICEBLUE);
            Text  text  =  new  Text(40,100,"JavaFX Scene");
            text.setFont(new Font(25));
            root.getChildren().add(text);
            return (scene);
        }
    }

    /**
     * Another random class for demonstration purposes
     * This would be similar to your FX Controllers
     */
    public static class RandomController{
        public void printFrameColor(){
            //Now from anywhere, I can get any of the top level items by calling the singleton
            System.out.println(MainController.getInstance().frame.getBackground());
        }
    }

    public static void main(String[] args){
        MainController.initialize();
        new RandomController().printFrameColor();


    }
}