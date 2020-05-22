static String[] studentNamesArray = new String[3];
    static int[][] studentMarksArray = new int[3][3];

    public static void main (String[] args) throws java.lang.Exception {
        studentNamesArray[0] = "Mark";
        studentNamesArray[1] = "Anna";
        studentNamesArray[2] = "Arnold";

        studentMarksArray[0] = new int[]{1,2,3};
        studentMarksArray[1] = new int[]{4,5,6};
        studentMarksArray[2] = new int[]{0,0,0};

        sortAlphabetical();
        System.out.println(Arrays.toString(studentNamesArray));
        System.out.println(Arrays.deepToString(studentMarksArray));

    }