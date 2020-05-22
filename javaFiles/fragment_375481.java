new Timer() {
        @Override
        public void run() {
            view.datagrid.setVisible(true);
            //call to merge column code or function
        }
    }.schedule(1000);