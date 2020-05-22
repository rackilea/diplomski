// create your output stream. Use the current running directory for your project
FileOutputStream fout = new FileOutputStream(new File(System.getProperty("user.dir"), "test.txt"));
// print it out so you know where it is... maybe?
System.out.println(new File(System.getProperty("user.dir"), "test.txt"));

byte[][] map = new byte[][] { { 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0 } };
// loop through your map, 2d style
for (int i = 0; i < map.length; i++) {
    for (int j = 0; j < map[i].length; j++) {
        // get the string value of your byte and print it out
        fout.write(String.valueOf(map[i][j]).getBytes());
    }
    // write out a new line. For different systems the character changes
    fout.write(System.getProperty("line.separator").getBytes());
}
// close the output stream
fout.close();