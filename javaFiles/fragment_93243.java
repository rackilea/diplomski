String url = "http://avail.mdx.ac.uk:8090/avail.js?";
// don't remove the questionmark otherwise the page won't update every time you run it
String [] site = loadStrings(url);
String [] list = split(site[0], ';');
for (int i = 0; i < list.length; i++) {
  if (list[i].contains("availgroup")) break; //stops the loop
  String [] elm = list[i].split(":");
  String ID = elm[0];
  int total = int(elm[1]);
  int used = int(elm[2]);
  println("Total: " + total + "  Used:" + used + "  Free: " + (total - used));
}