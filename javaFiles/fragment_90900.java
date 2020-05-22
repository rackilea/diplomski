public void hitDatabase() {
    Thread thread = new Thread(new DatabaseHelper());
    thread.start();
}

private static class DatabaseHelper implements Runnable {
    public void run() {
        //Hit the DB here
        codeToHitDB();

        //Once Complete update the GUI
        Runnable runnable = new Runnable() {
            public void run() {
                //Update your GUI
            }
        };

        SwingUtilities.invokeLater(runnable);
    }
}