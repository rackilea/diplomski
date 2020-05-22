public static boolean isTwinChars (String a, String b) {
        char[] aca = a.toLowerCase().toCharArray();
        char[] bca = b.toLowerCase().toCharArray();
        Arrays.sort(aca);
        Arrays.sort(bca);
        System.out.println(new String(aca));
        System.out.println(new String(bca));
        return new String(aca).equals(new String(bca));
    }