public static void main(String[] args) {
    int gridIndex = 10, myValue = 9999;
    setCell(myValue, gridIndex);
    System.out.println(gridIndex);
}

public static void setCell(int value, int gridIndex) {
    // In here, value is NOT the same variable, myValue, that
    // we passed in. Just the same, gridIndex, is not the same 
    // variable that we passed in from main.

    // In here, value and gridIndex have the SAME VALUES
    // as the variables we pass in, but they are not the same
    // variables. They are newly made variables, with the same values.
}