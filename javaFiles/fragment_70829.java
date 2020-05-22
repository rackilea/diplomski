int index= word.indexOf(" ");
do{
  System.out.println(word.substring(0, index));
  word = word.substring(index + 1);
  index = word.indexOf(" ");
} while (index != -1);