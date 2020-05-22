for (int i = 0; i < nl.getLength(); i++) {
        Element c_suggestion = (Element)nl.item(i);
        Element suggestion = c_suggestion.getElementsByTagName("Suggestion")
        String name = suggestion.getAttribute("data");
        System.out.println(name);
    }