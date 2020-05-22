PrintWriter out;
try {
    out = new PrintWriter("Character.txt");
    out.println(characterName);
    out.println(characterGender);
    out.close();
} catch (FileNotFoundException e) {
    System.err.println("File doesn't exist");
    e.printStackTrace();
}