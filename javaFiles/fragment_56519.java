String met = "This is the string with comma numberone; string having second wedaweda; last word";
int lastIndex = met.lastIndexOf(";");
int prevIndex = met.lastIndexOf(";", lastIndex - 1);
String laststringa = met.substring(prevIndex + 1, lastIndex).trim();
if (laststringa != null) {
    System.out.println(laststringa);
} else {
    System.out.println("No Words");
}