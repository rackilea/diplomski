Object myObj;
btn.setOnAction((ActionEvent event)->{
    /* some ui updates */
    myLabel.setText("something");
    try {
        /* try initiating object and doing some methods with them */
        Runnable timeConsumingTask = ()-> {
            myObj = new Object();
            myObj.doMethod();
        }
        Thread thread = new Thread(timeConsumingTask);
        thread.start();