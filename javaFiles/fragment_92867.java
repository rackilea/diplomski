public void calculateAverage() {
    averageGrade = gradeAccumulator / numberOfScores;
    if (averageGrade > 89) {
        averageGradeJTextField.setText("A");
    } // was missing
    else if (averageGrade > 79) {
        averageGradeJTextField.setText("B");
    } // was missing
    else if (averageGrade > 69) {
        averageGradeJTextField.setText("C");
    } // was missing
    else if (averageGrade > 64) {
        averageGradeJTextField.setText("D");
    } // was missing
    else {
        averageGradeJTextField.setText("F");
    } // was missing
}