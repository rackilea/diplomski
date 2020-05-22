public String encrypt(String input, int key){
    char[] chars = input.toUpperCase().replaceAll("[^A-Z]", "").toCharArray();
    for (int i = 0; i < chars.length; i++){
        chars[i] -= 65;
        chars[i] = (char)((chars[i] + key) % 26);
        chars[i] += 65;
    }
    return String.valueOf(chars);
}

public String decrypt(String input, int key){
    char[] chars = input.toUpperCase().replaceAll("[^A-Z]", "").toCharArray();
    for (int i = 0; i < chars.length; i++){
        chars[i] -= 65;
        chars[i] = (char)((chars[i] - key) % 26);
        chars[i] += 65;
    }
    return String.valueOf(chars);
}