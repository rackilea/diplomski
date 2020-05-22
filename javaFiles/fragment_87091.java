Text text = new Text(shell, SWT.BORDER);
    text.addModifyListener(new ModifyListener() {
        @Override
        public void modifyText(ModifyEvent e) {
            if(timer != null){
                timer.cancel();
            }
            timer = new Timer();                
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    //handler
                    System.out
                        .println("MainClass.main(...).new SelectionAdapter() {...}.widgetSelected(...).new TimerTask() {...}.run()");
                    timer.cancel();
                }
            }, 1000);
        }
    });