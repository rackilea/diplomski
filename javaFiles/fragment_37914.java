String[] split = str.split(("\\s*,\\s*")); //1. split into separate strings

List<String> list = new ArrayList<>(Arrays.asList(split));//convert into an ArrayList to allow removing

list.removeAll(Collections.singleton("'xyz'"));//2. remove anything you don't want
String result = String.join(",", list); //3. convert back to comma separated list