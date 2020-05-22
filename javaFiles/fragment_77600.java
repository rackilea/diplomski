if(cond1){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                sendmail(firstcond);
            }
        });
    } else{
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                sendmail(secondcond);
            }
        });
    }