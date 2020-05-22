private KeyGenerator<?> generator;

public AutoKeyMap(Class<?> keyType) {
    // WARNING: Unchecked cast from AutoKeyMap.IntKeyGen to AutoKeyMap.KeyGenerator<K>
    if (keyType == Integer.class) generator = new IntKeyGen();
    else throw new RuntimeException("Cannot generate keys for " + keyType);
}