public void actionPerformed(ActionEvent e) {

    currentIndex++;
    // You need to decide what to do when we reach the end of the array...

    String value = myStrings[currentIndex];
    textArea.setText(value);

}