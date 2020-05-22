public static String randomizeCase(String str) {

    Random rnd = new Random();
    StringBuilder sb = new StringBuilder(str.length());

    for (char c : str.toCharArray())
        sb.append(rnd.nextBoolean()
                      ? Character.toLowerCase(c)
                      : Character.toUpperCase(c));

    return sb.toString();
}