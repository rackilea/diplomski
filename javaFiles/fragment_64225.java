try (
        final FileOutputStream fos = new FileOutputStream(file);
        final DataOutputStream dos = new DataOutputStream(fos);
) {
    ....writing to file....

} catch (IOException e) {
    e.printStackTrace();
}