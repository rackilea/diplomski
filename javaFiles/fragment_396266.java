Document doc = Jsoup.parse("<html><body<select><option value=\"Savings\">Accounts</option></select></body></html>");

    String contentText = "Accounts";

    Elements elems = doc.select(":containsOwn(" + contentText + ")");

    for(Element e: elems) {
        System.out.println("Html : " + e.outerHtml());
        System.out.println("Tag  : " + e.tagName());
    }