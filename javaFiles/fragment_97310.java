JTextField textfield = new JTextField();
        textfield.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
                textfield.setText("");
            }
        });