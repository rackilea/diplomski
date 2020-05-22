private void magicSort(List<String> list, String seed) {
    list.sort(new HashComparator(seed, "SHA-1"));
}

public class HashComparator implements Comparator<String> {
    private static final long MAGIC = 0x5DEECE66DL;
    private final ThreadLocal<MessageDigest> messageDigest;
    private final byte[] seed;
    private final int seedHash;

    public HashComparator(String seed, String algorithm) {
        this.seed = seed.getBytes(ISO_8859_1);
        this.seedHash = seed.hashCode();
        this.messageDigest = ThreadLocal.withInitial(() -> {
            try {
                return MessageDigest.getInstance(algorithm);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        });
    }

    @Override
    public int compare(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }
        int diff = getSignature(s1).compareTo(getSignature(s2));
        if (diff != 0) {
            return diff;
        }
        long random = seedHash;
        random = random * MAGIC + s1.hashCode();
        random = random * MAGIC + s2.hashCode();
        return ((random & 1) == 0 ? 1 : -1) * s1.compareTo(s2);

    }

    private ByteBuffer getSignature(String s) {
        MessageDigest digest = messageDigest.get();
        digest.reset();
        digest.update(seed);
        for (int i = 0, size = s.length(); i < size; i++) {
            char c = s.charAt(i);
            digest.update((byte) (c >> 8));
            digest.update((byte) c);
        }
        return ByteBuffer.wrap(digest.digest());
    }
}