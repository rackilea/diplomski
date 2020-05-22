frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
new Timer().scheduleAtFixedRate(new TimerTask() {
    int counter = 0;

    @Override
    public void run() {
        counter++;
        if (counter >= 10) { // If ran 10 times, stop.
            this.cancel();
        }
        int answer = rn.nextInt(10) + 1;
        elements.add(answer);
        int sum = 0;
        for (int j = 0; j < elements.size(); j++) {
            sum = sum + elements.get(j);
        }
        double average = sum / elements.size();
        label.setText(String.valueOf(average)); // Set the text of the
                                                // label (automatically
                                                // repaints panel)
        System.out.println(String.valueOf(average));
    }
}, 500, 1000); // Run every second (= 1000 milliseconds), wait 500
                // milliseconds before starting it.