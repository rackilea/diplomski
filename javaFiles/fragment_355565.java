private Timer timer;
public void init()
{
    pane = new JPanel();
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

    clock = new JLabel("00:00");

    toggle = new JButton("Start/Stop");
    toggle.addActionListener(this);

    pane.add(clock);
    pane.add(toggle);

    timer = new Timer(500, new ActionListener() { 
        public void actionPerformed(ActionEvent evt) {
            long time = getElapsedTime();
            sidePanel.this.clock.setText(String.valueOf(time));        
        }
    });
    timer.setRepeats(true);
    add(pane);

}

@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == toggle)
    {
        if(timer.isRunning())
        {
            endTime = System.currentTimeMillis();
            timer.stop();
        }
        else
        {
            startTime = System.currentTimeMillis();
            timer.start();
        }
    }
}