public void save(String fileName) throws FileNotFoundException {
    PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
    for (Club club : clubs)
         pw.println(club); // call toString() on club, like club.toString()
    pw.close();
}