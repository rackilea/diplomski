table.addFocusListener(new FocusAdapter() {
        @Override
        public void focusLost(FocusEvent e) {
            loseCellFocus();
        }           
    });