dialog.addWindowListener(

    new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent event) {

            dialog.dispose();
        }
    }
);