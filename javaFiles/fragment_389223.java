while (flyerHTML.contains("\"longDescription\":")) {
    String longDescription = "";    

    // LONG DESCRIPTION
    flyerHTML = flyerHTML.substring(flyerHTML.indexOf("\"longDescription\":") + 18);

    if (flyerHTML.startsWith("null")) longDescription = "null";

    else longDescription = StringEscapeUtils.unescapeHtml4(flyerHTML.substring(1, flyerHTML.indexOf(",") - 1));
    longDescription = longDescription.replaceAll("\\r\\n|\\r|\\n", " ");
    System.out.println("LONG DESCRIPTION = " + longDescription);

    System.out.println("");
}