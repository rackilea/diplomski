List<String> list = new ArrayList<>();
long count = 0;
for (String elem : list) {
   if (elem.startsWith("C")) {
     count += elem.length();
   }
}