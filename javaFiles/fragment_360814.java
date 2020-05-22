private static String[] words = new String[]{"world", "you"};
private static String helloWorld = "Hello world how are you?";

public static String getHello() {
    String s = helloWorld;
    for (String word : words) {
        int index = s.toLowerCase().indexOf(word.toLowerCase());
        if (index >= 0) {
            String w = s.substring(index, index + word.length());
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(0, index));
            for (int i = 0; i < w.length(); i++) {
                sb.append(w.charAt(i));
                if (i < w.length() - 1)
                    sb.append("*");
            }
            sb.append(s.substring(index + w.length()));
            s = sb.toString();
        }
    }
    return s;
}

public static void main(String[] args) {
    System.out.println(getHello());
}