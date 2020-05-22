int delay = 10; //milliseconds
ActionListener taskPerformer = new ActionListener() {
    int count = 0;
    public void actionPerformed(ActionEvent evt) {
        count++;
        gui.setText(count + "");
        // System.out.println(count + "");
    }
};
Timer task = new Timer(delay, taskPerformer);
task.setCoalesce(false); // SOmetimes, executions can be missed because other programs 
task.setRepeating(true);
task.start();

// Later:
task.stop();