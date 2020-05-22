public static byte[] tiles;
//...
//here you add some tiles
//...
PrintWriter writer = new PrintWriter("mytxtdocument.txt", "UTF-8");
for(int i = 0; i < tiles.length; i++) {
        writer.println("BYTE: " + tiles[i]);
}
writer.close();