public void load() {
        try {
            File file = new File("AddressBook.txt");
            Scanner scanner = new Scanner(file);
            Person person;
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(" ");
                add(split[0], split[1]);
            }
        } catch (IOException e) {
            System.out.println("Error in input/output");
        }
    }