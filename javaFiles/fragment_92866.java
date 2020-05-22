public void calculateAverage() {
    averageGrade = gradeAccumulator / numberOfScores;
    if (averageGrade > 89) {
        averageGradeJTextField.setText("A");

        if (averageGrade > 79) {
            averageGradeJTextField.setText("B");

            if (averageGrade > 69) {
                averageGradeJTextField.setText("C");

                if (averageGrade > 64) {
                    averageGradeJTextField.setText("D");
                }
                else {
                    averageGradeJTextField.setText("F");
                }