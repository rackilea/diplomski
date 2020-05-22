import apple.laf.JRSUIConstants;
import com.apple.laf.AquaButtonBorder;
import java.awt.EventQueue;
import java.util.Objects;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AquaAlwaysDefaultButtonExample {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            final JFrame frame = new JFrame("Aqua Always Default Button Example");
            final JButton defaultButton = new JButton("Default Button");
            frame.getContentPane().add(defaultButton);
            defaultButton.setBorder(new AlwaysDefaultAquaButtonBorder());
            frame.getRootPane().setDefaultButton(defaultButton);
            frame.pack();
            frame.setLocationByPlatform(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    public static class AlwaysDefaultAquaButtonBorder extends AquaButtonBorder.Dynamic {

        @Override
        protected JRSUIConstants.Widget getStyleForSize(final AbstractButton b,
                                                        final JRSUIConstants.Size size,
                                                        final int width,
                                                        final int height) {
            if(b != null && b.getRootPane() != null
                    && Objects.equals(b, b.getRootPane().getDefaultButton())) {
                return JRSUIConstants.Widget.BUTTON_PUSH;
            }
            return super.getStyleForSize(b, size, width, height);
        }

    }

}