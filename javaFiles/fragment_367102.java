try (Scanner sc = new Scanner(System.in)) {
        String inputLite = sc.nextLine();

        try {
            FileWriter fileWriter = new FileWriter("/Test.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(inputLite);

            fileWriter.close();
            bufferedWriter.close();
            System.out.println("Success!");
        } catch (IOException e) {
            System.out.println("Failure");
        }


    }