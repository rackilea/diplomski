static int min = Integer.parseInt("100", 36);
static int range = Integer.parseInt("zzz", 36) - min;

public static String shortHash(String sha) {
    return Integer.toString(min + (sha.hashCode() & 0x7FFFFFFF) % range, 36);
}