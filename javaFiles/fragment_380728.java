String initialText = "Enter your story here...";
   ...
   jTextArea1.setText(initialText); 
   ...

   private void focusGained(java.awt.event.FocusEvent evt) {
        if (jTextArea1.getText().equals(initialText)) {
            //jTextArea1.setSelectionStart(0);
            //jTextArea1.setSelectionEnd(jTextArea1.getText().length());
            jTextArea1.selectAll();
        }
    }