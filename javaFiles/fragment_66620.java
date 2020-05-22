Document doc = JSoup.parse(page_text);
recursive_print(doc.head());
recursive_print(doc.body());

...

private static Set<String> ignore = new HashSet<String>(){{
  add("table");
  ...
}};
public static void recursive_print(Element el){
   if(!ignore.contains(el.className()))
     System.out.println(el.html());
   for(Element child : el.children())
     recursive_print(child);
}