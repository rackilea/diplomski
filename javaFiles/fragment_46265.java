private static void saveToFile(String fileName,
                               BigInteger mod, BigInteger exp) 
    throws SomeException {
    ObjectOutputStream oout = new ObjectOutputStream(
            new BufferedOutputStream(new FileOutputStream(fileName)));
    try {
        oout.writeObject(mod);
        oout.writeObject(exp);
    } catch (Exception e) {
        throw new SomeException(e);
    } finally {
        oout.close();
    }
}