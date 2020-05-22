public static void main(String[] args) {
    String string1 = "Great responsibility";
    char string[] = string1.toCharArray();
    HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
    for (int i = 0; i < string.length; i++) {
        for (int j = i + 1; j < string.length; j++) {
            Integer value = hashMap.get(string[i]);
            if (value == null) {
                value = 1;
            }
            if (string[i] == string[j]) {
                hashMap.put(string[i], value + 1);
            } else {
                hashMap.put(string[i], value);
            }
        }
    }
    System.out.println(hashMap);
}