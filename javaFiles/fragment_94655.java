@Override public void focusGained(FocusEvent e){
        JTextField jtf = (JTextField) e.getSource();
        if(jtf.getClientProperty("originalText").equals(jtf.getText())){
             jtf.setText("");
        }
    }