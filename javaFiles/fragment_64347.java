final class Gui extends JFrame {
  private Timer timer;
  private JLabel timerLabel;

  private void createWindow() {
    display = new Display();
    setLayout(new BorderLayout(3, 3));
    add(display, BorderLayout.CENTER);

    JPanel timerPanel = new JPanel();
    timerPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
    timerPanel.setBackground(new Color(0x00bcda));
    add(timerPanel, BorderLayout.PAGE_START);

    timerLabel = new JLabel("01:00", SwingConstants.RIGHT);
    timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
    timerLabel.setHorizontalAlignment(JLabel.RIGHT);
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 1;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridy = 0;
    timerLabel.setForeground(Color.black);
    timerPanel.add(timerLabel, c);

    initTimer();
  }

  private void initTimer() {
    timer = new Timer(1000, new ActionListener() {
      int time = 60;
      @Override
      public void actionPerformed(ActionEvent e) {
        time--;
        timerLabel.setText(format(time / 60) + ":" + format(time % 60));
        if (time == 0) {
          timer = (Timer) e.getSource();
          timer.stop();
        }
      }
    });
  }

  private class ButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
      String cmd = e.getActionCommand();
      if (cmd.equals("Quit")) {
        System.exit(0);
      } else if (cmd.equals("Start")) {
        timer.start();
      } else if (cmd.equals("Next")) {
        timer.stop();
        initTimer();
        timer.start();
      }
      display.repaint();
    }
  }
}