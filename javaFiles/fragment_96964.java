String name= "Android";
            updateGameInfo("Wait it's" + name + " turn");
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    cpuPlay();
                }
            },500);