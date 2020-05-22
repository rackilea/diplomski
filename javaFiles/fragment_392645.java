public static String enterPassword() {
   //gets a string and returns it
}

public static boolean checkPasswordLength(String password) {
   //if too long return false
}

//...
String password = enterPassword();
while ( !checkPasswordLength(password) ) {
    password = enterPassword();
}