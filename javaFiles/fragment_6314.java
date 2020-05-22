FileInputStream fileInputStream = new FileInputStream("numbers.txt");
Scanner scanner = new Scanner(fileInputStream);


while (scanner.hasNextDouble()) {
        int num = Double.valueOf(scanner.nextDouble()).intValue();
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

scanner.close();