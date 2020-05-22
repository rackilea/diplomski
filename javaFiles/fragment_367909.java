// Create an array of JTextArea
JTextArea[] jTextAreas = new JTextArea[10];
// Iterate on all the possible indexes
for(int i=0;i<jTextAreas.length;i++) {
    // Create a new instance of JTextArea for the current index
    jTextAreas[i] = new JTextArea();
    // Set dynamically the text
    jTextAreas[i].setText(Integer.toString(i));
}