public static void main(String[] args) throws FileNotFoundException {

    File inputFile = new File("numbersandwords.txt");
    Scanner scan = new Scanner(inputFile).useDelimiter(" ");
    String[] words = new String[20];
    int[] numbers = new int[20];
    int i = 0;
    int j=0;

    while (scan.hasNext()) {
        String s = scan.next();
        if (isInteger(s)) {
            numbers[i] = Integer.parseInt(s);
            i++;
        }else{
            words[j] = s;
            j++;
        }

    }

    System.out.println(Arrays.toString(words));
    System.out.println(Arrays.toString(numbers));
}

public static boolean isInteger(String s) {
    try {
        int myInt = Integer.parseInt(s.trim());
        return true;
    } catch (Exception e) {
        return false;
    }
}