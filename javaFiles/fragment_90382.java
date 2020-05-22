protected String parseHash() {
    try {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

        strings.removeIf(str -> str == null || str.isEmpty());
        for(int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            string = string.replace("|", "\\|");
            strings.set(i, string);
        }
        String input = String.join("|", strings);
        byte[] hash = digest.digest(input.getBytes());
        return DatatypeConverter.printHexBinary(hash);
    } catch(NoSuchAlgorithmException e) {
        return null;
    }
}