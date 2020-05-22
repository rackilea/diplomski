public static void getFileInfo(String fileName) throws FileNotFoundException {

Scanner in = new Scanner(new File(fileName));
Score = 0;

    while (in.hasNext()) { 
    String fileContent = in.nextLine();
    String result = removeSpaces(fileContent);

    double first = Double.parseDouble(fileContent.substring(0, fileContent.indexOf(" ")));
    char operator = getOperator(fileContent);
    double second = secondNumber(result, fileContent);
    double last = Double.parseDouble(result.substring(result.indexOf("=") + 1));

    double math = mathChecking(first, second, operator);

    mathGrading(math , last);

    }
    System.out.println(Score);

}