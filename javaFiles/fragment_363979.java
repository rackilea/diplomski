String[] charArray = currentItem.split("\\+");
for(int i = 0; i < charArray[1].length(); i++){
   String getWord = charArray[charArray.length - 1];
   StringBuilder sb = new StringBuilder(getWord);
   String addWord = (getWord.charAt(i) + charArray[0] + "+" + sb.deleteCharAt(i).toString());
   System.out.println(addWord);
   permStack.push(addWord);

}