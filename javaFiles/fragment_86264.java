Document doc = Jsoup.parse(input, "UTF-8");
    Elements elem = doc.select(".blueTab header h2");
    for (Iterator<Element> iterator = elem.iterator(); iterator.hasNext();)
    {
        Element element = iterator.next();
        if (element.text().equals("Energy")) // your comparison  text
        {
            Element tableElement = element.parent().nextElementSibling(); //Your got the expected table Element as per your requirement
        }

    }