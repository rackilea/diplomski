ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            //...Perform a task...

        }
    };
    Timer timer = new Timer(10 ,taskPerformer);
    timer.start();