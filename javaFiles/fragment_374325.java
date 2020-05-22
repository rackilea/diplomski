t1.addFocusListener(new FocusListener() {

        @Override
        public void focusLost(FocusEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void focusGained(FocusEvent arg0) {
            // TODO Auto-generated method stub
            t1_selected = true;
            t2_selected = false;
        }
    });
    t2.addFocusListener(new FocusListener() {

        @Override
        public void focusLost(FocusEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void focusGained(FocusEvent e) {
            // TODO Auto-generated method stub
            t1_selected = false;
            t2_selected = true;
        }
    });