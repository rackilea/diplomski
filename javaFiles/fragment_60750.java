public void appendChunk(byte[] data, File file) throws IOException {
    DataOutputStream stream = null;
    try {
        stream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file, true)));
        stream.writeInt(data.length);
        stream.write(data);
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