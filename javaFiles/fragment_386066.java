public static Note newFromFile(NoteManager noteManager, Context context,
        String filename) throws IOException
{
    Path path = Paths.get(filename);
    byte[] bytes = Files.readAllBytes(path);
    String content = new String(bytes,  "UTF-8");

    Note n = new Note(noteManager, content.trim());
    n.fileName = filename;
    noteManager.add(n); // One registration?
    return n;
}