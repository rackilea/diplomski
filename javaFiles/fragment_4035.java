File file = new File("C:\\Storage\\Model-1.0.0.jar");
byte[] data = Files.toByteArray(file);
StorageObjectIdentifier objIdentifier =
    new StorageObjectIdentifier("Model", "1.0.0", name);

client.createObject(objIdentifier, data);