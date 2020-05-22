int[] colors = {#2962ff, #00bfa5, #ff6d00, #aa00ff};
        Random random = new Random();
        int myRandString = random.nextInt(colors.length);

        // My Buttons
        inGridLayout00.setBackgroundColor(Color.parseColor(colors[myRandString]));
        inGridLayout01.setBackgroundColor(Color.parseColor(colors[myRandString]));
        inGridLayout10.setBackgroundColor(Color.parseColor(colors[myRandString]));
        inGridLayout11.setBackgroundColor(Color.parseColor(colors[myRandString]));