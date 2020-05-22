ClassLoader cipherLoader =
    new URLClassLoader(new URL[]{new URL("jar:file:myAdditional.jar")},
                       Cipher.class.getClassLoader());
ServiceLoader<Cipher> serviceLoader = ServiceLoader.load(Cipher.class, cipherLoader);
for(Cipher c : serviceLoader) {
    c.encrypt(...);
}