private void displayInstructions() {
    final Handler handler = new Handler();
    int delay = 0;
    int step = 5000;

    for (Emergency_Instructions instruction : instructions) {
        final Emergency_Instructions instruction2 = instruction;

        handler.postDelayed(new Runnable() {
            public void run() {
                displayimages(instruction2.getStep(), instruction2.getStepImage());
                // handler.postDelayed(this, 5000);
            }
        }, delay);

        delay += step;
    }
}