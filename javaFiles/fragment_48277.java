private void updateTable(){
 for(int i=0;i<300;i++)
    {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ie) {
            // ignore!
            ie.printStackTrace();
        }
        model.addRow(new Object[]{i,i,i});
        /**************This message dialog box show row updated to refresh table for viewing***********/
        //Must schedule the close before the dialog becomes visible
        JFrame closeDialog = new JFrame();
        final JDialog dialog = new JDialog(closeDialog, "Updated", true);

        ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
        s.schedule(new Runnable() {
            public void run() {
                dialog.setVisible(false); //should be invoked on the EDT
                dialog.dispose();
            }
        }, 500, TimeUnit.MILLISECONDS);

        dialog.setVisible(true); // if modal, application will pause here

        //System.out.println("Dialog closed");
        /**************This message dialog box show row updated to refresh table for viewing***********/

    }}