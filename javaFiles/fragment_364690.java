public static void main(String[] args) throws Exception {
    //create ouput file
    PrintWriter output = new PrintWriter("output2.txt");
    BufferedReader file1 = new BufferedReader(new FileReader("numbers1.txt"));
    BufferedReader file2 = new BufferedReader(new FileReader("numbers2.txt"));

    try {
        // read data from file
        while (true) {
            String number1AsString = file1.readLine();
            String number2AsString = file2.readLine();
            if (number1AsString == null || number2AsString == null) {
                break;
            }
            double number1 = Double.parseDouble(number1AsString);
            double number2 = Double.parseDouble(number2AsString);
            double result = number1 * number2;
            System.out.println("result:" + result);
            output.println(result);
        }
    } catch (IOException e) {
        System.out.println(e.getMessage());
    } finally {
        output.close();
        file1.close();
        file2.close();
    }
}