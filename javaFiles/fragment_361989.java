EventQueue.invokeAndWait(new Runnable() {
        @Override
        public void run() {
            searchDlg.setVisible( true );
            assertTrue( searchDlg.queryString == null );
        }
    });
    Robot robot = new Robot();
    robot.delay( 10 );
    EventQueue.invokeAndWait(new Runnable() {
        @Override
        public void run() {
            // now passes
            assertTrue( app.mainFrame.searchDlg.inputJTF.hasFocus() );
        }
    });