public double average() {
    return (((quiz1 + quiz2)/40 * 25) + 
            (midterm/100 * 35) + 
            (finalExam/100 * 40));
}

public String toString(){
    DecimalFormat dec = new DecimalFormat("#.0");
    String averageString = dec.format(average();
    return ("The average score is " + averageString); // just an example
}