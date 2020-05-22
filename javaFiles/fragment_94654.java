private FocusListener callback = new FocusListener() {
    @Override public void focusGained(FocusEvent e){
        JTextField jtf = (JTextField) e.getSource();
        if(hasBeenSet){}else{jtf.setText("");hasBeenSet=true;}
    }
    ...