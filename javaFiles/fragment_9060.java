private final static int MAX_WIDTH = 80;

public String wrap(String longString) {
    String[] splittedString = longString.split(" ");
    String resultString = "";
    String lineString = "";

    for (int i = 0; i < splittedString.length; i++) {
        if (lineString.isEmpty()) {
            lineString += splittedString[i];
        } else if (lineString.length() + splittedString[i].length() < MAX_WIDTH) {
            lineString += splittedString[i];
        } else {
            resultString += lineString + "\n";
            lineString = "";
        }
    }

    if(!lineString.isEmpty()){
            resultString += lineString + "\n";
    }

    return resultString;
}