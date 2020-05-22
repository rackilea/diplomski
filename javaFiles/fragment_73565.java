public static void main(String[] args) {
    String[][] myArray = { { "X0", "", "Z1" }, 
            { "X1", "", "Z1" }, 
            { "X2", "", "Z2" } };

    for (int j = 0; j < myArray.length; j++) {
            myArray[j][1] = String.valueOf(superSkills[j]);
    }

    System.out.println(Arrays.deepToString(myArray));
}