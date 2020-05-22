//Do the stuff you had

JButton button = new JButton("Start");
int ticks = 0;

Timer t = new Timer(1000, (event) -> {
    JTFHours.setText(Integer.toString(ticks / 360));
    JTFMinutes.setText(Integer.toString(ticks / 60));
    JTFSeconds.setText(Integer.toString(ticks % 60));
    ticks = ticks + 1;
});

button.addActionListener((event) -> t.start());