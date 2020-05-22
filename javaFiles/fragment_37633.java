private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {   
    Stack stack = new Stack();
    int number = (int) (Integer.parseInt(jTextField1.getText()));
    while (number > 0) {
        stack.push(number % 10);
        number = number / 10;
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.empty()) {
        sb.append(stack.pop());
        if (!stack.empty()) {
            sb.append(",");
        }
    }
    jLabel2.setText(sb.toString());
}