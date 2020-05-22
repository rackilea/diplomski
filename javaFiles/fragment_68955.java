Elements nameElements = doc.select("div.name");

    for (Element element : nameElements) {
        if (element.select("span").isEmpty()) {
            System.out.println("No span");
            System.out.println(element.text());
            System.out.println();
        } else {
            System.out.println("span");
            System.out.println(element.text());
            System.out.println();
        }
    }