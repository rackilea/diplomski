public synchronized void abcCaller() {
    this.timer.cancel(); //this will cancel the current task. if there is no active task, nothing happens
    this.timer = new Timer();

    TimerTask action = new TimerTask() {
        public void run() {
            YourClassType.abc(); //as you said in the comments: abc is a static method
        }

    };

    this.timer.schedule(action, 60000); //this starts the task
}