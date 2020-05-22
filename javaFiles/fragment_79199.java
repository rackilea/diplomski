private List<String> extractListOfSections() {

        String content = parse.getXMLHandler().toString();
        Document doc = Jsoup.parse(content);
        List<Element> link = doc.select("h, h1, h2, h3, h4, h5, h6");

        List<String> headings = new ArrayList<String>();

        for (Element element : link) {
            if (element.text() != null) {
                headings.add(element.text().replaceAll("\\p{P}", " "));
            }
        }

        return headings;

    }