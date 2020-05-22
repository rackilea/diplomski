Set<Integer> indexes = new TreeSet<>();
String message = "Hi, my name is john, and Hello";
for (String word : Speach2R){
    if (message.contains(word)){
        indexes.add(Speach2R.indexOf(word));
    }
}