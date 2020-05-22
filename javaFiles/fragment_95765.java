public static void main(String[] args) {
    String input = "$nick=someone$$message=something$";
    String nick = null;
    String message = null;

    java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\$nick=(.+?)\\$\\$message=(.+?)\\$");
    java.util.regex.Matcher m = p.matcher(input);
    if (m.find()) {
        nick = m.group(1);
        message = m.group(2);
    }

    System.out.println("Nick: "+nick);
    System.out.println("Message: "+message);
}