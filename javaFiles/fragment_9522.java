public enum Colors{
     REDISH ("red", "crimson", "pink"),
     BLUEISH ("blue", "oceanic", "sky", "darkblue", "lightblue"),
     YELLOWISH ("yellow", "orange");

     private List<String> values;

     Colors(String ...strings){
         values = Arrays.asList(strings);
     }
}