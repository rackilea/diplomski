try {
        Scanner scanner = new Scanner(new File("myFile.txt"));

        long[] values = new long[100];

        int i = 0;
        while (scanner.hasNextLong()) {

            values[i] = scanner.nextLong();
            i++;
        }
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }