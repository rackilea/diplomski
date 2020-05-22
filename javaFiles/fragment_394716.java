List<Character> vowelList = new ArrayList<>();
...
for (int i = 0; i < statement.length(); i++) {
    if (alpha == 'a' || alpha == 'e' || alpha == 'i' || alpha == 'o' || alpha == 'u') {
         vowels++;
         vowelList.add(alpha);
     } else {

     ...
}
System.out.println("The vowels are as follows:");
System.out.println(vowelList);