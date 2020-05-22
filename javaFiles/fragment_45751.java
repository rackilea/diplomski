import java.awt.*;
import javax.swing.*;

public class BoxLayoutVertical extends JFrame
{
    public BoxLayoutVertical()
    {
        Box box = Box.createVerticalBox();

        JButton button = new JButton("A button");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        box.add(button);

        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        box.add(progressBar);

        JPanel panel = new JPanel( new BorderLayout() );
        JLabel label = new JLabel("A label");
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(label);
        box.add(panel);

        add(box, BorderLayout.NORTH);
    }

    public static void main(String[] args)
    {
        BoxLayoutVertical frame = new BoxLayoutVertical();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.setSize(300, 200);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}