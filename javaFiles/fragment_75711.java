String[] subKeyword = data.split(" ");
if(subKeyword.length > 1){
  String subKwd = subKeyword[1];
  if(subKwd.length() == 0){
    System.out.println("Zero letters");
  } else if(subKwd.length() == 1){
    System.out.println("One letter");
  } else {
    System.out.println("More letters");
  }
} else {
  System.out.println("No subkeyword present in data");
}