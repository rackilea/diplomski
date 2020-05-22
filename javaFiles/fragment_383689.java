WindowAdapter adapter = new WindowAdapter() {
        @Override
        public void windowLostFocus(WindowEvent e) {
            System.out.println("Focus Lost");
        }
        @Override
        public void windowClosing(WindowEvent e) {
            //some other stuff here that work
        }
    };
appFrame.addWindowListener(adapter);
appFrame.addWindowFocusListener(adapter);