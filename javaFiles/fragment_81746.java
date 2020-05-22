private String letterGrade;
private double numericGrade;

public Grade(String letterGrade) {
    this.letterGrade = letterGrade;
    if (letterGrade.startsWith("A")) {
        numericGrade = 4.0;
    } else if (letterGrade.startsWith("B")) {
        numericGrade = 3.0;
    } else if (letterGrade.startsWith("C")) {
        numericGrade = 2.0;
    } else if (letterGrade.startsWith("D")) {
        numericGrade = 1.0;
    } else if (letterGrade.startsWith("F")) {
        numericGrade = 0.0;
    }

    if (letterGrade.substring(1).equals("+")) {
        numericGrade += .3;
    } else if (letterGrade.substring(1).equals("-")) {
        if (numericGrade > 0) {
            numericGrade -= .3; // <-- or an F- is -0.3
        }
    }
}

public double getNumericGrade() {
    // System.out.println(numericGrade);
    return numericGrade;
}