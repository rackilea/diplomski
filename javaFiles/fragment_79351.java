String removeSlash(String file) {
     char[] letters = file.toCharArray();
     if (file.charAt(0) == '/'){ //first character is '/'
         return file.substring(1);
     } else {
         return file;
     }
}