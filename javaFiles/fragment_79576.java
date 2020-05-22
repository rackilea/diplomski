private Timer timer;
...
label.setText("Hi");
// delay of 4 seconds
timer=new Timer(4000,new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        label.setText("Hello");
        // timer.stop(); // stop the timer if repeated mode is on
    }
});
timer.setRepeats(false); // you can turn-on it if needed
timer.start();