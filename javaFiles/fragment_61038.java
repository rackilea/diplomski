Document d = Jsoup.parse("<a href=\"/wiki/Kategorie:Herrscher_des_Mittelalters\" title=\"Kategorie:Herrscher des Mittelalters\">Herrscher des Mittelalters</a>");

    Elements links = d.select("a");

    Set<String> categories = new HashSet<>();
    for (Element script : links) {
        String title = script.attr("title");
        if (title.length() > 0) {
            categories.add(title);
        }

    }

    System.out.println(categories);