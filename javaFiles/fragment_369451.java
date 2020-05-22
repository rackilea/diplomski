String text = "like yes";
if (text.contains("like") && !text.contains("not")) {
    System.out.println("like yes");
}
text = "like not";
if (text.contains("like") && !text.contains("not")) {
    System.out.println("like not");
}