static class BadHash {
    @Override
    public int hashCode() {
        return 1;
    }
}

public static void main(String... args) {
    Map<BadHash, Boolean> map = new HashMap<BadHash, Boolean>();
    for (int i = 0; i <= 100000; i++) {
        if (i % 10000 == 0) System.out.println(i + ": " + new Date());
        map.put(new BadHash(), true);
    }
}