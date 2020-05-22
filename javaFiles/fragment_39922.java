handler.postDelayed(runnable = new Runnable() {
            public void run() {
                //do your function;
                getSystemObject();
                handler.postDelayed(runnable, apiDelayed); // Remove this
            }
        }, apiDelayed);