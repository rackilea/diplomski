public static String createRandomCode(int codeLength, String id) {
    return new SecureRandom()
            .ints(codeLength, 0, id.length())
            .mapToObj(id::charAt)
            .map(Object::toString)
            .collect(Collectors.joining());
}