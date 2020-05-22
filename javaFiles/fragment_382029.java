BufferedReader answer = new BufferedReader(new InputStreamReader(System.in));
String addNewUser = answer.readLine();
char i = addNewUser.toUpperCase().charAt(0);
if (i == 'Y') {
    //Handle yes
} else if (i == 'N') {
    //Handle no
} else {
    System.out.println("You've mistyped the answer.");
}