try {
        File file = new File("program.java");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine())
        System.out.println(scanner.nextLine());
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }