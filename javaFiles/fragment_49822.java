String passwordInFile = map.get(user)
 if (passwordInFile != null && passwordInFile.equals(pass)) {
     System.out.println("True");
 } else {
     System.out.println("False");
 }