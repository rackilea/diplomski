Timer timer = new Timer(1000, new ActionListener() {

     int i = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        i++;
        label.setText(String.valueOf(i));
    }
};

timer.setRepeats(true); // it will be repeated every 1 sec.
timer.start();