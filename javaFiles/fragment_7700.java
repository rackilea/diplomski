import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Math.min;

public class BouncingBall extends Frame
                implements ActionListener, AdjustmentListener, Runnable {

    private boolean done = false;
    Thread theThread;

    int sbVis = 10;
    int sbMin = 1;
    int sbMax = 100 + sbVis;
    int sbUnitInc = 3;
    int sbBlockInc = 20;
    private final int DELAY = 10;
    long delay = (long) (DELAY * (double) ((sbMax - sbMin) / 100));

//  private Panel canvas = new Panel();
    private Panel control = new Panel();

    Scrollbar speedSB;
    Scrollbar sizeSB;
    Button runBtn;
    Button pauseBtn;
    Button quitBtn;
    Label speedLabel;
    Label sizeLabel;
    Screen s = new Screen();

    Rectangle ZERORECT = new Rectangle(0, 0, 0, 0);
    private boolean newRect = true;
    int x1, x2, y1, y2;

    BouncingBall() {
        this.setLayout(new BorderLayout());
//      canvas.setLayout(new BorderLayout());
        initComponents();
        this.setVisible(true);
        start();
    }

//main function
    public static void main(String[] args) {
        BouncingBall b = new BouncingBall();
    } //end main function

    private void initComponents() {
        //set up main frame layout and add the components to the correct location
        this.setTitle("Bouncing Ball");
        this.setSize(640, 480);

        this.add(s, BorderLayout.CENTER);
        this.add(control, BorderLayout.SOUTH);
        s.setBackground(Color.WHITE);

        s.setConstraintListener(new Screen.ConstraintListener() {
            @Override
            public void constraintsChanged(Dimension size) {
                System.out.println("Size = " + size);
                Insets insets = getInsets();
                int minWidth = size.width + (insets.left + insets.right);
                int minHeight = size.height + control.getPreferredSize().height + (insets.top + insets.bottom);
                System.out.println(minWidth + " - " + minHeight);
                setMinimumSize(new Dimension(minWidth, minHeight));
            }
        });

//      canvas.add(s, BorderLayout.CENTER);

        //listeners on this frame
//      this.addComponentListener(new ComponentAdapter() {
//          private boolean ignoreNext = false;
//          @Override
//          public void componentResized(ComponentEvent e) {
//              if (ignoreNext) {
//                  ignoreNext = false;
//                  return;
//              }
//              Insets insets = getInsets();
//              ignoreNext = true;
//              int minWidth = canvas.getMinimumSize().width;
//              int minHeight = canvas.getMinimumSize().height + control.getPreferredSize().height;
//              int width = Math.max(getWidth(), minWidth + (insets.left + insets.right));
//              int height = Math.max(getHeight(), minHeight + (insets.top + insets.bottom));
//              setSize(width, height);
//          }
//      });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                stop();
            }
        });

        //add buttons, scrollbars, and labels
        speedSB = new Scrollbar(Scrollbar.HORIZONTAL);
        speedSB.setMinimum(sbMin);
        speedSB.setMaximum(sbMax);
        speedSB.setVisibleAmount(sbVis);
        speedSB.setUnitIncrement(sbUnitInc);
        speedSB.setBlockIncrement(sbBlockInc);
        speedSB.addAdjustmentListener(this);
        sizeSB = new Scrollbar(Scrollbar.HORIZONTAL);
        sizeSB.setMinimum(15);
        sizeSB.setMaximum(sbMax);
        sizeSB.setVisibleAmount(sbVis);
        sizeSB.setUnitIncrement(sbUnitInc);
        sizeSB.setBlockIncrement(sbBlockInc);
        sizeSB.addAdjustmentListener(this);
        sizeSB.setValue(s.ball.width);
        runBtn = new Button("Run");
        runBtn.addActionListener(this);
        runBtn.setEnabled(false);
        pauseBtn = new Button("Pause");
        pauseBtn.addActionListener(this);
        quitBtn = new Button("Quit");
        quitBtn.addActionListener(this);
        speedLabel = new Label("Speed");
        sizeLabel = new Label("Size");

        //setup the layout of the control panel
        GridBagLayout lm = new GridBagLayout();
        control.setLayout(lm);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.weightx = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 30, 5, 30);
        control.add(speedSB, c);

        c.insets = new Insets(10, 0, 5, 0);
        c.gridx = 1;
        c.gridy = 0;
        control.add(runBtn, c);

        c.gridx = 2;
        c.gridy = 0;
        control.add(pauseBtn, c);

        c.gridx = 3;
        c.gridy = 0;
        control.add(quitBtn, c);

        c.insets = new Insets(10, 30, 5, 30);
        c.gridx = 4;
        c.gridy = 0;
        control.add(sizeSB, c);

        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 1;
        control.add(speedLabel, c);

        c.gridx = 4;
        c.gridy = 1;
        control.add(sizeLabel, c);
        s.repaint();
    }

    public Rectangle makeRect() {
        int width = this.x1 - this.x2;
        int height = this.y1 - this.y2;
        Rectangle rect = new Rectangle(min(this.x1, this.x2), min(this.y1, this.y2), Math.abs(width), Math.abs(height));
        return rect;
    }

    public void run() {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        while (true) {
            try {
                theThread.sleep(0);
                while (!done) {//pause variable
                    s.step();
                    try {
                        theThread.sleep(delay); //move speed
                    } catch (InterruptedException e) {
                    }
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public void start() { //begin overloaded start()
        if (theThread == null) {
            theThread = new Thread(this);
            theThread.start();
        }
    }

    public void stop() {
        sizeSB.removeAdjustmentListener(this);
        speedSB.removeAdjustmentListener(this);
        dispose();
        System.exit(0);
    }//end stop()

//canvas object
//overloaded listeners
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == quitBtn) {
            stop();
        } else if (o == runBtn) {
            done = false;
            runBtn.setEnabled(false);
            pauseBtn.setEnabled(true);
        } else if (o == pauseBtn) {
            done = true;
            runBtn.setEnabled(true);
            pauseBtn.setEnabled(false);
        }
    }

    public void adjustmentValueChanged(AdjustmentEvent e) {
        Object obj = e.getSource();
        if (obj == sizeSB) {
            int objSize;
            int maxSize = min(s.getWidth() - s.ballX(), s.getHeight() - s.ballY());
            if (maxSize > e.getValue()) {
                objSize = e.getValue();
                s.setObjSize(objSize);
            } else {
                objSize = maxSize;
                s.setObjSize(objSize);
                sizeSB.setValue(objSize);
            }
        }
        if (obj == speedSB) {
            int speed = e.getValue();
            delay = (long) (DELAY * (double) (sbMax - speed + 1) / 100);
            theThread.interrupt();
        }
    }
//end overloaded listeners
}