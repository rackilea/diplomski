private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Get the inputs the user entered
    int input1 = Integer.valueOf(jTextField1.getText());
    int input2 = Integer.valueOf(jTextField2.getText());

    // use your other class to do something
    int result = new MyAverager().average(input1,input2);

    // Display the result for a user.
    jTextField3.setText(Integer.toString(result));
}