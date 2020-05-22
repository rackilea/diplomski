try (Scanner sc = new Scanner(new File(fileName));
     PrintWriter outputStream = new PrintWriter(fileNameOutput);) {
    while (sc.hasNextLine()) {
        outputStream.println(sc.next());// write first word from line
        sc.nextLine();// consume rest of text from that line
    }
} catch (IOException e) {
    e.printStackTrace();
}