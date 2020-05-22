private static BigInteger hashString(String s) {
    BigInteger THIRTY_ONE = BigInteger.valueOf(31); // You should promote this to a class constant!

    if (s == null) return BigInteger.ONE; // An empty/null string will return 1.

    BigInteger r = BigInteger.ONE; // The value of r will be returned by this method
    List<Character> charList = new ArrayList<>(); 
    String lowercase = s.toLowerCase(); // This gets us around case sensitivity

    for (int i = 0; i < lowercase.length(); i++) {
        Character c = Character.valueOf(lowercase.charAt(i));
        if (Character.isWhitespace(c)) continue; // spaces don't count
        charList.add(c); // Note the character for future processing...
    }

    // Now we have a list of Characters... Sort it!
    Collections.sort(charList);

    // Calculate our bighash, similar to how java's List interface does.
    for (Character c : charList) {
        int charHash = c.hashCode();
        r=r.multiply(THIRTY_ONE).add(BigInteger.valueOf(charHash));
    }

    return r;
}