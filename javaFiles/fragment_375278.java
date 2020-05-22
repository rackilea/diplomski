import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;
import javax.swing.Timer;

public class MouseMovementMonitor {

    private Point startPoint;
    private Point currentPoint;
    private Long  startTime;
    private Timer timer;

    public MouseMovementMonitor(JComponent componentToMonitor, int motionTimeDelay, final MouseMovementListener movementListener) {
        timer = new Timer(motionTimeDelay, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(startPoint != null && !startPoint.equals(currentPoint)) {
                    movementListener.movementOccured(
                            new MouseMovementEvent(startPoint, currentPoint, startTime, System.nanoTime())
                        );
                }

                startPoint = null; // either can be 
                startTime  = null;

                // or reset process can be as follow instead of the two above lines: 
                // startPoint = currentPoint;
                // startTime  = System.nanoTime();

                timer.stop();
            }

        });

        componentToMonitor.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                if(startPoint == null) {
                    startPoint = e.getPoint();
                    startTime  = System.nanoTime();
                }
                currentPoint = e.getPoint();
                //
                if(timer.isRunning())
                    timer.restart();
                else
                    timer.start();
            }
        });
    }
}