timer = new Timer(50, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int width = frame.getWidth();
        int height = frame.getHeight();
        int buttonWidth = chatButton.getWidth();
        if(frame.getWidth() < 1150) {
            width = frame.getWidth();
            frame.setSize(width + 2 , height);
            chatButton.setLocation(width - buttonWidth , 0);
            frame.invalidate();
            frame.validate();
         } else {
            ((Timer)e.getSource()).cancel()
         } 
     });
timer.setInitialDelay(0);
timer.start();