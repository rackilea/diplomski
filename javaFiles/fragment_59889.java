private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {
        if(evt.getSource()==jTextField2){
            int jml = Integer.parseInt(jTextField3.getText());
            jTextField1.setText(numberToWord(jml));

        }
    }