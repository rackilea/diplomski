import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class MovingSlideShow {
    private static String[] data;

    public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
        buildFrame();
        }
    });
    }

    private static void populateData() {
        try {
            Scanner sc = new Scanner(new File("File.txt"));
            List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
          lines.add(sc.nextLine());
        }

        data = lines.toArray(new String[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void buildFrame() {
    populateData();
    JFrame f = new JFrame("SlideShow");
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JPanel p = new JPanel();
    p.setPreferredSize(new Dimension(500, 500));
    p.setLayout(null);

    final JLabel label = new JLabel("Starting Text on Label");
    label.setLocation(200, 0);
    label.setSize(label.getPreferredSize());
    p.add(label);

    Timer timer = new Timer(1000, new TimerListener(label));
        timer.start();

    f.add(p);
    f.pack();
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    }

    static class TimerListener implements ActionListener {

    private Random random;
        private JLabel label; 

        public TimerListener(JLabel label){
            this.label = label;
            random = new Random();
        }

        public void actionPerformed(ActionEvent e) {
            label.setText(data[random.nextInt(data.length)]);
            label.setLocation(random.nextInt(400), random.nextInt(400));
        }
    }
}