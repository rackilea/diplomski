File f = new File("actions.txt");
try{
    Scanner scanner = new Scanner(f);
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        System.out.println(line);
        Thread.sleep(2000);
    }
    scanner.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}catch (InterruptedException e) {
    e.printStackTrace();
}
System.exit(0); // terminate the program