import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FillExample extends JFrame {

    private static final int FRAMEL_DEFAULT_WIDTH = 700;
    private static final int FRAME_DEFAULT_HEIGHT = 400;

    private static final int BUTTON_HEIGHT = Integer.MAX_VALUE;

    private final List<JButton> buttons;

    public FillExample() {
        buttons = new ArrayList<>();
    }

    public void createAndShow() {
        setTitle("Fill Example");
        setSize(FRAMEL_DEFAULT_WIDTH, FRAME_DEFAULT_HEIGHT);

        final JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.X_AXIS));

        for (int i = 0; i < 3; i++) {
            addButtons(buttonContainer);
        }

        getContentPane().add(buttonContainer);

        buttonContainer.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent ce) {
                fixComponentWidths(buttonContainer, buttons, BUTTON_HEIGHT);
            }

            @Override
            public void componentMoved(ComponentEvent ce) {
            }

            @Override
            public void componentShown(ComponentEvent ce) {
            }

            @Override
            public void componentHidden(ComponentEvent ce) {
            }
        });

        setVisible(true);
    }

    private static void fixComponentWidths(Component container, List<? extends Component> componentList, int componentHeight) {
        if (!componentList.isEmpty()) {
            int baseComponentWidth = container.getWidth() / componentList.size();
            int remainder = container.getWidth() % componentList.size();
            for (int i = 0; i < componentList.size(); i++) {
                int componentWidth = baseComponentWidth;
                if (i < remainder) {
                    componentWidth++;
                }
                componentList.get(i).setMaximumSize(new Dimension(componentWidth, componentHeight));
            }
            container.revalidate();
        }
    }

    private void addButtons(JComponent component) {
        Color[] colorA = {Color.RED, Color.BLUE, Color.BLACK, Color.GREEN};
        for (Color c : colorA) {
            JButton button = createButton(c);
            buttons.add(button);
            component.add(button);
        }
    }

    private static JButton createButton(Color color) {
        JButton button = new JButton();
        button.setBackground(color);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, BUTTON_HEIGHT));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FillExample().createAndShow();
            }
        });
    }

}