String[] data;
try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream(file)))) {
    data = (String[]) in.readObject();
}