import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.util.*;
import java.util.List;

public class ButtonBackgroundAndIcon {
    private static final List<Color> BACKGROUND_COLORS = Arrays.asList(
            new Color(229, 119, 120),
            Color.BLUE,
            Color.CYAN,
            Color.GREEN,
            Color.YELLOW,
            Color.RED
    );

    private int backgroundIndex;

    public static void main(String[] arguments) {
        SwingUtilities.invokeLater(new ButtonBackgroundAndIcon()::run);
    }

    private void run() {
        JFrame frame = new JFrame("Stack Overflow");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton tileButton = new JButton();
        tileButton.setBackground(BACKGROUND_COLORS.get(0));

        Icon icon = getRoyIcon();
        if (icon != null) {
            tileButton.setIcon(icon);
        }

        tileButton.addActionListener(actionEvent -> {
            backgroundIndex = (backgroundIndex + 1) % BACKGROUND_COLORS.size();
            tileButton.setBackground(BACKGROUND_COLORS.get(backgroundIndex));
        });

        frame.getContentPane().add(tileButton);

        frame.setVisible(true);
    }

    private ImageIcon getRoyIcon() {
        ImageIcon imageIcon;

        try {
            String iconLocation = "http://orig06.deviantart.net/fd0e/f/2008"
                                  + "/060/d/1/roy_sprite_by_chstuba007.gif";
            imageIcon = new ImageIcon(new URL(iconLocation));
        } catch (MalformedURLException e) {
            imageIcon = null;
        }

        return imageIcon;
    }
}