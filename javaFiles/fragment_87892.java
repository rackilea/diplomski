ArrayList<Integer> marks = new ArrayList<Integer>();

// Called when the user clicks a button
public void actionPerformed(ActionEvent e) {
    Object clickedButton = e.getSource();
    if(clickedButton == addButton) {
        addButtonActionPerformed();
    }
    else if(clickedButton == sortButton) {
        sortButtonActionPerformed();
    }
    else if(clickedButton == analyzeButton) {
        analyzeButtonActionPerformed();
    }
}

 private void addButtonActionPerformed() {
    Collections.addAll(marks, (Integer.parseInt(markInput.getText())));

    StringBuilder text = new StringBuilder();
    for (Integer mark: marks) {
        text.append(mark.toString()).append('\n');
    }

    markdisplayTextArea.setText(text.toString());
}

 private void sortButtonActionPerformed() {
    Collections.sort(marks);

    StringBuilder text = new StringBuilder();
    for (Integer mark: marks) {
        text.append(mark.toString()).append('\n');
    }

    markdisplayTextArea.setText(text.toString());
}

private void analyzeButtonActionPerformed() {

    String output = "Class average:" + calculateAverage() + "\n" +
                    "Maximum mark:" + calculateMaximum() + "\n" +
                    "Minimum mark:" + calcualteMinimum() + "\n" +
                    "Range of marks:" + calculateRange();

    analyzeTextArea.setText(output);
}

private int calculateAverage(){
    // calculate and return the answer
}

private int calculateMaximum(){
    // calculate and return the answer
    int maximum = 0;
    for (Integer currentMark: marks){
        if (currentMark > maximum){
            maximum = currentMark;
        }
    }
    return maximum;
}

private int calcualteMinimum(){
    // calculate and return the answer
}

private int calculateRange(){
    // calculate and return the answer
}