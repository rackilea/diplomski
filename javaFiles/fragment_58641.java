import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class LabelAsBackground {

    public static final String HTML =
        "<html>" +
        "<style type'text/css'>" +
        "body, html { padding: 0px; margin: 0px; }" +
        "</style>" +
        "<body>" +
        "<img src='http://pscode.org/media/starzoom-thumb.gif'" +
        " width=320 height=240>" +
        "";

    LabelAsBackground() {
        JFrame f = new JFrame("Animated Image BG");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel contentPane = new JLabel(HTML);
        contentPane.setLayout(new GridLayout());
        JPanel gui = new JPanel(new GridLayout(3,3,15,15));
        gui.setOpaque(false);
        contentPane.add(gui);
        gui.setBorder(new EmptyBorder(20,20,20,20));
        for (int ii=1; ii<10; ii++) {
            gui.add( new JButton("" + ii));
        }
        f.setContentPane(contentPane);
        f.pack();
        //f.setResizable(false); // uncomment to see strange effect..
        f.setVisible(true);
    }

    public static void main(String[] args) {
        //Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                LabelAsBackground lab = new LabelAsBackground();
            }
        });
    }
}