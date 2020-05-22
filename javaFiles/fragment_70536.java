public static void write(String filename, Map<String, Set<Long>> data) throws IOException {
    try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
            new DeflaterOutputStream(new FileOutputStream(filename))))) {
        dos.writeInt(data.size());
        for (Map.Entry<String, Set<Long>> entry : data.entrySet()) {
            dos.writeUTF(entry.getKey());
            Set<Long> value = entry.getValue();
            dos.writeInt(value.size());
            for (Long l : value) {
                dos.writeLong(l);
            }
        }
    }
}