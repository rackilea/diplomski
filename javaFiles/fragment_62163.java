container.setLayout(new GridLayout(totalSizeOfArray+3,2));
    for(int i = 0; i < totalSizeOfArray; i++){
        studentNamesEnteredLast = new JTextField();
        studentNamesEnteredFirst = new JTextField();
        studentNamesEnteredFirst.setEditable(false);
        studentNamesEnteredLast.setEditable(false);
        studentNamesEnteredLast.setText(studentNameLast.get(i));
        studentNamesEnteredFirst.setText(sortedStudentNameFirst.get(i));
        container.add(studentNamesEnteredLast);
        container.add(studentNamesEnteredFirst);
    }