int delay = 5000; // delay in milliseconds 

ActionListener taskPerformer = new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { //...Perform a task... } }; 
    Timer timer = new Timer(delay, taskPerformer);
    timer.setRepeats(false); 
    timer.start(); // timer starts - after delay time your task gets executed