public static AreaToUse valueOfInt(int i) {
    return Arrays.stream(AreaToUse.values())
            .filter(e -> e.getQualified() == i)
            .findFirst()
            .orElse(null);
}