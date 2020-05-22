redBut.performClick();
        redBut.setPressed(true);
        redBut.invalidate();
        new Handler().postDelayed(new Runnable() {
        @Override
            public void run() {

               redBut.setPressed(false);
               redBut.invalidate();
             }
        }, 500);