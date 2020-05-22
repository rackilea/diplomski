public void thingsPart1() {
        // code1

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                thingsPart2();
            }
        }, 500);
    }

    public void thingsPart2() {
        // code 2
    }