String name = "shady";
String password = "OnePunchMan";

char[] encryptingPassword = password.toCharArray();


for(int i=0; i < encryptingPassword.length; i++){
     encryptingPassword[i] += '5';
}