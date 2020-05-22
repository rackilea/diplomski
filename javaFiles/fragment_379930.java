String s = ":33: 88 app 2/8\nsuperman taman, puchong\n36100, Malaysia\n:22: bla bla \\bla /bla\nbla bla\n:32: 45//dsfd//qdsfqsdf\n:72D: Example";
Pattern pattern = Pattern.compile("(?m)^(:\\d{2}[A-Z]?:)(.*(?:\r?\n(?!:\\d{2}[A-Z]?:).*)*)");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println("--- NEXT PAIR ---"); 
    System.out.println("Key:" + matcher.group(1));
    System.out.println("Value:" + matcher.group(2)); 
}