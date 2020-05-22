package paranoid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MasterFrame {

public static void main(String[] args) {
        // TODO Auto-generated method stub
new MasterFrame();
}


public MasterFrame(){
    JFrame f = new JFrame();
    f.setTitle("Kaleidoscope");
    final Trip2 trip2UI = new Trip2();
    final TripModel model = new TripModel();
    model.update();
    Timer timer = new Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.update();
        }
    });
    timer.setRepeats(true);
    timer.start();

    model.addListener(new TripModelListener() {
        @Override
        public void modelChanged() {
            trip2UI.repaint();
        }
    });
    trip2UI.setModel(model);

    f.add(trip2UI);
    f.setSize(500,300);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    f.setResizable(false);

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}