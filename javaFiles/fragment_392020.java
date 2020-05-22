//inside MySwingWorker
@Override
protected void done() {
    try {
        System.out.println("My long running database process is done. Now I can update UI without blocking/freezing it.");
        GMSnapshotVO snap = get();
        loadingJPanel.updateStatus("Complete");
        loadingJFrame.dispose();
        productIds = snap.getProductIds();
        oldLocationIds = snap.getOldLocationIds();
        oldStatusIds = snap.getOldStatusIds();
        //..do other stuff with ids
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }
}