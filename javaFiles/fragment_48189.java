public Object[] randomArrayString(int length, int numberOfChar){
    Random random = new Random();
    char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    return Stream.generate(() -> {
        String str="";
        for (int i = 0; i < numberOfChar; i++) {
            str+= chars[random.nextInt(chars.length - 1)];
        }
        return str;
    }).limit(length).toArray();
}