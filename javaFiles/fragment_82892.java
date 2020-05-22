private void scanSystem() {
    new Thread(() -> {
        double startScanTime = System.currentTimeMillis();
        //Preparing Event
        String startupTaskText = "System Scan has started!";
        double startUpProgress = 0;
        String taskID = App.addTask(startupTaskText, startUpProgress);

        String [][] snapshotArray = manager.getSystemSnapshotsScanSystem(); //Get snapshots from Manager in Array
        tableScanSystemForSnapshots.setItems(getSnapshot(snapshotArray)); //push values to observableList

        double endScanTime = System.currentTimeMillis();
        String updateStartupTaskText = "System Scan finished in "+ ((endScanTime-startScanTime)/1000) + " Seconds";
        startUpProgress = 1;
        updateTask(taskID, updateStartupTaskText, startUpProgress);
    }).start();

}