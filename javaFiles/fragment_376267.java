import java.awt.*;
import javax.swing.*;

public class MainGUI {

    private JFrame frame;
    private JTextField textField;
    private String[] loremIpsum = {
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ut nulla egestas arcu rhoncus molestie. Mauris eget consequat sem, a accumsan eros. Praesent sem massa, dignissim sit amet porta ut, interdum sit amet ligula. Pellentesque cursus odio vel vestibulum vulputate. Donec facilisis ex sed pellentesque laoreet. Praesent ut sem id lectus suscipit pulvinar. Mauris a eros dui. Nulla ultrices est eu lacinia sagittis. Vivamus ac erat sit amet dolor ultricies euismod. Curabitur condimentum in ante id mattis. Pellentesque non sagittis diam. Nulla dapibus lacus sagittis turpis vehicula, vitae eleifend odio euismod. Sed elementum facilisis nisl. Donec lectus nulla, rutrum ac sollicitudin pulvinar, tempus ut arcu. Maecenas ut vulputate purus. In luctus cursus magna sit amet facilisis.",
        "Morbi vitae dictum enim, quis porttitor elit. Nam quis accumsan leo, id rhoncus tortor. Praesent tellus magna, ultrices quis nulla vel, fringilla ultricies purus. In hendrerit volutpat elit a posuere. Duis scelerisque, sapien eu faucibus eleifend, lectus lacus interdum diam, sed bibendum orci est ut urna. Quisque a sem iaculis ex aliquam tempor. In id dictum ex, non gravida lacus. Integer neque mauris, tristique eu ultrices quis, tristique pellentesque nunc. Donec egestas tristique dolor, ac sagittis ante elementum non.",
        "Mauris sit amet ullamcorper erat. Nunc non condimentum augue. Vivamus et odio eget massa convallis vulputate nec ut lacus. Donec sapien dolor, facilisis sit amet venenatis sit amet, suscipit ut nisi. Praesent vitae lorem lacinia orci volutpat fermentum. Nullam dolor erat, facilisis vitae volutpat id, feugiat et augue. Nunc congue, lectus a vehicula lacinia, est libero volutpat quam, nec maximus ante mauris eu urna. Etiam nunc dolor, auctor et orci vitae, pulvinar pretium orci. Nam et est rhoncus, pharetra mauris id, condimentum leo. In fermentum non urna sed imperdiet. Cras sit amet nulla eget purus convallis accumsan. Donec dictum eget magna pulvinar scelerisque. Fusce efficitur nisl sed nibh vestibulum laoreet.",
        "Morbi tincidunt eleifend nisl. Nullam libero massa, imperdiet vitae egestas eu, sodales ac lacus. Donec eu commodo dui. Suspendisse potenti. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean vel diam volutpat, gravida quam vitae, tristique dui. Cras aliquet gravida massa eget lobortis. Donec ullamcorper eu purus eget iaculis. Ut id leo erat. Etiam iaculis ante eu mi molestie suscipit.",
        "Quisque dapibus consectetur mauris eu faucibus. Etiam ac varius odio. Nulla non elit velit. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus est leo, ultricies quis sem ut, euismod vestibulum augue. Donec auctor eu nisi a aliquam. Integer libero sapien, fringilla ac posuere ut, malesuada ut leo. Maecenas ut ante non arcu molestie gravida nec eu neque. Vivamus elit nisi, auctor at luctus eget, accumsan id dolor."
    };

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainGUI window = new MainGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainGUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("HTML in editor pane");
        frame.setLocationByPlatform(true);
        //frame.setBounds(500, 200, /*W*/ 600, /*H*/ 435); this is guessing!
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StringBuilder sb = new StringBuilder(
                "<html><body style='width: 400px;'>");
        for (String s : loremIpsum) {
            sb.append("<p>");
            sb.append(s);
        }
        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setText(sb.toString());
        JScrollPane scrollPane = new JScrollPane(
                editorPane, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                // this is an important line!
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
        editorPane.setCaretPosition(0);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        // it should be the correct size needed to display the content,
        // but now let's make it half that height.
        Dimension d = frame.getSize();
        d = new Dimension(d.width, d.height/2);
        frame.setSize(d);
    }
}