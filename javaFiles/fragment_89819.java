if(savedInstance!=null){

        if (savedInstance.getBoolean("savedState")) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                   //load data from saved State
                }
            },100);

        } else {
            //only fire the async if the current fragment is the one visible, else the onResumeAndShowFragment will trigger the same async when it becomes visible


            if (savedInstance.getBoolean("amIVisible")) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //load data from net
                    }
                },100);

            }
        }
    }