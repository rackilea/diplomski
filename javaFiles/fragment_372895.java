String text = "This text is styled with some of the text formatting properties.  \n"
   + "  The heading uses the text-align, text-transform, and color\n"
   + "\n"
   + "properties. The paragraph is indented, aligned, and the space \n"
   + "     \n";
String result = text.replaceAll("(?m)^\\s+", "").replaceAll("(?m)\\s+$", "");