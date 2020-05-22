int timerinterval = (int) Toolkit.getDefaultToolkit().
                              getDesktopProperty("awt.multiClickInterval");

        final Timer timer = new Timer(timerinterval, new ActionListener()
        {
          public void actionPerformed(ActionEvent acEvt)
          {
            internalFrame2.setVisible(false);
          }
        });

        jb.addMouseListener(new MouseAdapter()
        {
          public void mouseClicked(final MouseEvent evt)
          {
            System.out.println("Button " + evt.getClickCount());
            timer.setRepeats(false);
            timer.start();
            if (evt.getClickCount() > 1)
            {
              timer.restart();
            }
          }
        });