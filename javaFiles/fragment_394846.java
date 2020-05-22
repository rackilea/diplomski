backgroundProcess = new SwingWorker<Boolean, Void>() {

        @Override
        protected Boolean doInBackground() throws Exception {
            // paste the MySQL code stuff here
        }

        @Override
        protected void done() {
            // Process ended, mark some ended flag here
            // or show result dialog, messageBox, etc      
        }
    };