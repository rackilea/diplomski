import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

public class Test3 {

    protected static void initUI() {
        JFrame frame = new JFrame("Test text pane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextPane text = new JTextPane();
        text.setText(LONG_TEXT);
        JScrollPane scrollPane = new JScrollPane(text);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(scrollPane, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                0, 0, 0, 0), 0, 0));
        frame.add(panel);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                initUI();
            }
        });
    }

    private static final String LONG_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In molestie purus vel ipsum commodo id bibendum est porta. Proin leo nisl, facilisis eu euismod eget, fermentum a lacus. Nulla pulvinar ante at elit tristique condimentum. Suspendisse ac erat eu lectus vulputate sagittis sed a urna. In diam ligula, blandit id scelerisque sit amet, porttitor in libero. Curabitur in rhoncus tellus. Aenean dignissim dui semper ante pharetra interdum scelerisque vel tortor. Vestibulum id arcu mauris. Integer ut magna purus. Mauris orci massa, porta sollicitudin rutrum eu, ultrices non leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla sem justo, dapibus in euismod et, gravida sit amet eros.\r\n"
            + "\r\n"
            + "Suspendisse id ligula sit amet neque euismod commodo in at massa. Sed pretium lobortis vulputate. Aliquam non eros odio, non accumsan nisi. Phasellus vel nisl tellus, quis tincidunt risus. Donec ut nulla felis. Morbi sit amet enim arcu. Integer iaculis mi id sem vulputate non lacinia dui dictum.\r\n"
            + "\r\n"
            + "Praesent luctus neque in purus convallis vel aliquet dui rutrum. In lobortis nisl eu nisi tincidunt adipiscing sodales sapien sodales. Morbi augue massa, dictum vel hendrerit vel, tincidunt id lectus. Proin vulputate nunc placerat ante fringilla vitae ullamcorper mauris fringilla. Duis et massa sapien. Integer porta elementum enim in lobortis. Morbi eget mi nunc. Quisque nec arcu eget orci elementum consectetur ut in metus.\r\n"
            + "\r\n"
            + "Donec iaculis felis vel felis rutrum id congue tellus aliquet. Ut vel sapien mauris, quis sodales odio. Aliquam cursus urna a leo lacinia eget porttitor ante mattis. Aenean dictum, tellus in volutpat luctus, magna eros feugiat tortor, nec lobortis diam justo vel est. Praesent sit amet nisl sed eros semper ultrices. Nunc lobortis scelerisque sapien, ac sodales nibh viverra ac. Etiam auctor, odio ut venenatis hendrerit, odio ipsum sollicitudin libero, non adipiscing nisi eros at nulla. Nulla consequat arcu in libero pellentesque sit amet aliquet arcu elementum. Nulla facilisi. Proin sodales neque quis turpis gravida ac mollis ipsum ultricies. Mauris lorem magna, ultricies a dignissim sit amet, egestas et neque. Phasellus iaculis pellentesque ultrices. Phasellus a consectetur nisl. Proin ac quam id lectus dignissim lacinia. Praesent ligula purus, mattis eu pellentesque nec, convallis id lorem.\r\n"
            + "\r\n"
            + "Cras at sapien vitae felis fermentum consectetur sed eu justo. Mauris in felis mi. Vestibulum felis neque, varius at aliquet non, ornare at eros. In hac habitasse platea dictumst. Vivamus placerat, tellus laoreet pulvinar tempor, velit elit aliquet diam, eu ullamcorper purus enim non lectus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Etiam et enim magna. Ut varius, lectus at luctus laoreet, urna mauris euismod velit, vitae sodales nulla nulla non sem. Phasellus eget viverra erat. Phasellus quam ante, vehicula sed tristique vestibulum, ullamcorper et nunc. Phasellus placerat congue tellus, condimentum volutpat ligula convallis fringilla. Curabitur quis nibh lorem, ut feugiat velit. Aliquam vehicula pellentesque aliquet. ";
}