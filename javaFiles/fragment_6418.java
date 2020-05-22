int delay = 1000;
Timer timer = new Timer(delay, null);

public Constructor(){
    timer = new Timer(delay, new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            if (counter >= inputA) {
                timer.stop();
            } else {

                // do something
            }
        }
    });
    button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            timer.start();
        }
    });

}