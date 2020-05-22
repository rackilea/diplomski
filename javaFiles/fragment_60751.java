public void processChunks(File file) throws IOException {
    DataInputStream stream = null;
    try {
        stream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        while (true) {
            try {
                int length = stream.readInt();
                byte[] data = new byte[length];
                stream.readFully(data);
                // todo: do something with the data
            } catch (EOFException e) {
                // end of file reached
                break;
            }
        }
    } finally {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                // ignore
            }
        }
    }
}