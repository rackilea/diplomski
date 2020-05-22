String[] items = {"One:10.1.22.33", "Two:10.1.21.23", "Three:10.1.21.33", "Four:10.1.21.23", "Five:10.1.22.23"};
String q = "Two";  //need to find index of element starting with substring "Two"
for (int i = 0; i < items.length; i++) {
    if (items[i].startsWith(q)) {
        System.out.println(i);
    }
}