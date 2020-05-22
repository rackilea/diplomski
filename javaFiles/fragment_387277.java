jTextField1.addKeyListener(new KeyAdapter() {
    public void keyReleased(KeyEvent e) {
        String text = "" + e.getKeyChar();
        StringBuffer buffer = new StringBuffer(jTextField1.getText().substring(0, jTextField1.getText().length() - 1));
        buffer.append(text);
        ListModel<String> model = jList1.getModel();
        int index; 
        for(int i = 0; i < model.getSize(); i++) {
            if(model.getElementAt(i).contains(buffer.toString())){
                index = i;
                break;
            }
        }

        jList1.setSelectedIndex(index);
    }
});