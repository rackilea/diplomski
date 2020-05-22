List<String> decryptedPasswordInPairs = new ArrayList<String>();
    String A5 = "A5";

    List<String> oddPairsInEncryptedPassword = new LinkedList<String>();
    oddPairsInEncryptedPassword.add("A2");

    for (String oddPair : oddPairsInEncryptedPassword) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < oddPair.length(); i++) {
            byte x = (byte) (oddPair.charAt(i) ^ A5.charAt(i % A5.length()));
            sb.append(""+x);
        }

        String result = sb.toString();
        System.out.println(result);
        decryptedPasswordInPairs.add(result);
    }