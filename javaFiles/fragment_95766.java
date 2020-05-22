public static void main(String[] args) {
    String input = "$nick=someone$$message=something$";
    String nick = input.substring(input.indexOf("$nick=")+"$nick=".length(), input.indexOf("$$message="));
    String message = input.substring(input.indexOf("$$message=")+"$$message=".length(),input.length()-1);

    System.out.println("Nick: "+nick);
    System.out.println("Message: "+message);
}