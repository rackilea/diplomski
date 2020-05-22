public class Testing {
    private Timer timer; /* INIT this from somewhere.... */

    public void myFunction() {
    /* 60 Seconds */
    long countDownTimeSEC = 60; 
    /* convert to Miliseconds */
    long countDownTimeMS = 1000 * countDownTimeSEC; 

    /* Get ref to label */
    JLabel label = m_GameApplet.GetJpanelStartNetGame().GetJlabelSeconds(); 

    /* Set once */
    label.setFont(new java.awt.Font("Lucida Handwriting", 1, 36)); 
    label.setForeground(Color.red);

    /* Set initial time */
    label.setText(Long.toString(countDownTimeSEC)); 

    /* Get ref to button */
    JButton button = m_GameApplet.GetJpanelStartNetGame().GetJbuttonFinish(); 

    /* Set up post Count Down list */
    ArrayList<AbstractAction> actsWhenComplete = new ArrayList<AbstractAction>();

    /* instantiate countdown object */
    CountDownClockAction cdca = new CountDownClockAction(label, countDownTimeMS, actsWhenComplete);
    this.timer  = new Timer(1000, cdca);

    /* Now that we have a timer, add the post Count Down action(s) to the  post Count Down list */
    actsWhenComplete.add(new CountDownFinishAction(label, button, this.timer));


    /* Finally, kick off the timer */
    this.timer.start();
}

public static class CountDownClockAction extends AbstractAction {
    private static final long serialVersionUID = 1L;
    private final JLabel labelToUpdate;
    private final long startMS;
    private long currentMS;
    private long timeMark;
    private final ArrayList<AbstractAction> actionsToExeWhenComplete;
    private boolean actionsExedFlag;

    public CountDownClockAction(
            final JLabel labelToUpdate, 
            final long startMS, 
            ArrayList<AbstractAction> actionsToExeWhenComplete
    ) {
        super();
        this.labelToUpdate = labelToUpdate;
        this.startMS = startMS;
        this.currentMS = startMS;
        this.timeMark = 0;
        this.actionsExedFlag = false;
        this.actionsToExeWhenComplete = actionsToExeWhenComplete;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        /* First time firing */
        if (this.timeMark == 0) 
            this.timeMark = System.currentTimeMillis();

        /* Although the Timer object was set to 1000ms intervals, 
         * the UpdateClockAction doesn't know this, nor should it
         * since > or < 1000ms intervals could happen to do the fact that
         * the JVM nor the OS have perfectly accurate timing, nor do they
         * have instantaneous code execution properties.
         * So, we should see what the *real* time diff is...
         */
        long timeDelta = System.currentTimeMillis() - this.timeMark;

        /* Allow for the label to be null */
        if (this.labelToUpdate != null)
            labelToUpdate.setText(Long.toString((long)(currentMS / 1000)));

        if (currentMS > 0) {
            currentMS -= timeDelta;

        } else if (currentMS <= 0 && this.actionsExedFlag == false) {
            /* Ensure actions only fired once */
            this.actionsExedFlag = true;
            /* Allow for the label to be null */            
            if (this.actionsToExeWhenComplete != null)
                for (AbstractAction aa: this.actionsToExeWhenComplete)
                aa.actionPerformed(e);
        }

        /* Finally, update timeMark for next calls */
        this.timeMark = System.currentTimeMillis();
    }
}

public static class CountDownFinishAction extends AbstractAction {
    private final JLabel labelToUpdate;
    private final JButton buttonToUpdate;
    private final Timer timerToStop;

    public CountDownFinishAction(
            JLabel labelToUpdate,
            JButton buttonToUpdate, 
            Timer timerToStop
    ) {
        super();
        this.labelToUpdate = labelToUpdate;
        this.buttonToUpdate = buttonToUpdate;
        this.timerToStop = timerToStop;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        /* Perform actions, allowing for items to be null */
        if (this.labelToUpdate != null)
            this.labelToUpdate.setText("0");

        if (this.buttonToUpdate != null)
                this.buttonToUpdate.setVisible(false);

            if (this.timerToStop != null)
                this.timerToStop.stop();
        }
    }
}