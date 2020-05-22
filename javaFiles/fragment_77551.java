String userName = "John";
String password = "5john123";
if (password.toLowerCase().contains(userName.toLowerCase())) {
    System.out.println("Error! Your password cannot include your username");
} else {
    System.out.println("valid password");
}