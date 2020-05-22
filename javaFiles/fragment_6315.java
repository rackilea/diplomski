FileInputStream fileInputStream = new FileInputStream("numbers.txt");
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNext()) {
            // scanner.next() gets the next token
            // replaceAll() replaces every digits with * (\d is equal to [0-9] and it needs to be escaped with \ giving \\d)
            System.out.println(scanner.next().replaceAll("\\d", "*"));
        }

        scanner.close();
        fileInputStream.close();