final short[] salt = { 0xAA, 0xBB, ...};


final Hasher hasher = Hashing.sha256().newHasher();
hasher.putLong(input);
for (int i=0; i < salt.length; i++) {
    hasher.putShort(salt[i]);
}
return hasher.hash().asBytes();