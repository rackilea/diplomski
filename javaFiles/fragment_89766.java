String inputUserName = userName.getText();  //assign the user's input username
String inputPassword = password.getText();  //assign the user's input password

if(inputUserName.equals(userAdmin[0]) && inputPassword.equals(userAdmin[1])){
     System.out.println("Welcome Admin!");
}else if(inputUserName.equals(userAlexander [0]) && inputPassword.equals(userAlexander[1])){
     System.out.println("Welcome Alexander!");
}else{
     System.out.println("Unauthorized access");
}