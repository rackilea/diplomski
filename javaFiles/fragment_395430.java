final Closer closer = Closer.create();
final FileOutputStream out;
final OutputStreamWriter writer;
final BufferedWriter buffered;

try {
    out = closer.register(new FileOutputStream(file), encoding));
    writer = closer.register(new OutputStreamWriter(out));
    buffered = closer.register(new BufferedWriter(writer));
    // do stuff
} catch (IOException e) {
    throw closer.rethrow(e);
} finally {
    closer.close();
}