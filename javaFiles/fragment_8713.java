public static double sumNumbers(String filename) {
    Scanner s = null;
    try {
        s = new Scanner(new File(filename)).useDelimiter("\\s+");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    while (s.hasNext()) {
        if (s.hasNextInt()) {
            System.out.println(s.nextInt());
        } else if (s.hasNextDouble()) {
            System.out.println(s.nextDouble());
        } else {
            s.next();
        }
    }
    return 0;
}