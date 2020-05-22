@Override
public String toString() {
    String s = "ID: " + id + ", Final Mark: " + degreeMark + ", Classification: " + degreeClass + System.lineSeparator();
    if(calcBorderline()) {
        s += "Candidate is BORDERLINE" + System.lineSeparator();
    }
    return s;
}