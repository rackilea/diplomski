addWindowListener(new WindowAdapter() {

        @Override
        public void windowOpened(WindowEvent e) {
            new File("C:\\foo\\bar").mkdir();
        }

});