MySwingWorker myWorker = new MySwingWorkerClass(args).execute();

button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
        // Stop the swing worker thread
        myWorker.cancel(true);
    }
});