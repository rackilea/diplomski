String myString = "width:17px;background:#555;float:left;";
String[] sections = myString.split(";"); // split string in multiple sections
for (String section : sections) {

  // check if this section contains a width definition
  if (section.matches("width\\s*:\\s*(\\d+)px.*")) {
    System.out.println("width: " + section.split(":")[1].trim());
  }

  // check if this section contains a background definition
  if (section.matches("background\\s*:\\s*#[0-9A-Fa-f]+.*")) {
    System.out.println("background: " + section.split(":")[1].trim());
  }

  ...
}