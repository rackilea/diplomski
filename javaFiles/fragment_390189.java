public static void generateRoom(File file) throws FileNotFoundException {
    if (file.exists()) {
        Scanner sc = new Scanner(file);
        int row = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.startsWith("#"))
                continue;
            for (int col = 0; col < line.length(); col++) {
                switch (line.charAt(col)) {
                case 'W':
                    System.out.println("new wall @" + row + '/' + col);
                    break;
                case '0':
                    System.out.println("hero @" + row + '/' + col);
                    // fall-through
                case '1':
                case '2':
                    System.out.println("new door @" + row + '/' + col);
                    break;
                case ' ':
                    System.out.println("new floor tile @" + row + '/' + col);
                    break;
                default:
                    System.out.println("invalid char @" + row + '/' + col);
                }
            }
            row++;
        }
        sc.close();
    } else
        System.out.println("Ficheiro " + file.getAbsolutePath() + " nã£o existe.");
}