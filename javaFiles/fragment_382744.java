String[] words = {"cowboy", "animal", "monster"};
String s = "My friend is a Cowboy";
boolean check = false;

for (int i = 0; i < words.length; i++) {
    if (s.toLowerCase().contains(words[i].toLowerCase())) {
        check = true;
    } else {

    }
}
if (check) {
     System.out.println("Yes");
} else {
     System.out.println("No");
}