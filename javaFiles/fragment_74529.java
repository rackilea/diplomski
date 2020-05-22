List<String> a = new List<String>();
a.add("Hello");

List<String> b = new List<String>();
b.add("World");

List<List<String>> ls = new List<List<String>>();
ls.add(a);
ls.add(b);

//The outer part (ie. one List of a List of strings
for(List<String> ls : twodaray) {

    //The inner part (ie. one string for each list of strings)
    for(String str : ls) {

       //Check two things for equality (.equals() for strings)
       if (str.equals("Hello")) {
           //Adding "something" to the list (that str is in);
           ls.add("something");
       }
    }
}