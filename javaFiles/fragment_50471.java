int count = 0;
String filePath = "/dir1/testFile.txt";
try (Scanner sc = new Scanner(new File(filePath));) {
    while (sc.hasNextLine()) {
        String line = sc.nextLine();
        count++;
    }
} catch (Exception e) {
    e.printStackTrace();
}
System.out.printf("No: of lines : %d%n", count);