public static void main(String[] args) throws FileNotFoundException {
        Scanner userInput = new Scanner(System.in);
        Scanner fileInput = null;
        String a = null;
        int sum = 0;
        do {
            try {
                System.out
                        .println("Please enter the name of a file or type QUIT to finish");
                a = userInput.nextLine();
                if (a.equals("QUIT")) {
                    System.exit(0);
                }
                fileInput = new Scanner(new File(a));
            } catch (FileNotFoundException e) {
                System.out.println("Error " + a + " does not exist.");
            }
        } while (fileInput == null);

        PrintWriter output = null;
        try {
            output = new PrintWriter(new File("result.txt"));
        } catch (IOException g) {
            System.out.println("Error");
            System.exit(0);
        }
        while (fileInput.hasNext()) {
            if (fileInput.hasNextInt()) {
                int num = fileInput.nextInt();
                sum += num;
                String str = Integer.toString(num);
                output.println(str);
            } else {
                fileInput.next();
            }
        }
        fileInput.close();
        output.close();
    }
}