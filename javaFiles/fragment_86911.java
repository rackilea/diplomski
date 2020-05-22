public static void main(String args[]) throws FileNotFoundException {
        Scanner file1 = new Scanner(new File("d:\\data.txt"));
        int lengt_h = 0;
        while (file1.hasNext()) {
            lengt_h++;
            file1.next();
        }
        file1 = new Scanner(new File("d:\\data.txt")); // again put file pointer at beginning
        int[] numberArray = new int[lengt_h];
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = file1.nextInt();       // read integer from file
        }
        for (int n : numberArray)
            System.out.print(n + " ");
    }