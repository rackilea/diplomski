String document = "Header: blah blah \n Header: blah blah"

String[] sections = document.split("\n");
String[] headers = new String[sections.length];
String[] bodies = new String[sections.length];;

for(int i = 0; i < sections.length; i++){
      headers[i] = sections[i].split(":")[0];
      bodies[i] = sections[i].substring(headers[i].length() + 2);
}