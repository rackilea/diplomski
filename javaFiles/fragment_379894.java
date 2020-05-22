Certification certification = null;
try {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(ch.getCertificationData(process, version));
    oos.flush();
    certification = (Certification) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject();
} catch (IOException | ClassNotFoundException ex) {
}