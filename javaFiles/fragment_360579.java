Document document = Jsoup.parse(html, "", Parser.xmlParser());
        for (Element element : document.select("*")) {
            if (!element.ownText().isEmpty()) {
                for (TextNode node : element.textNodes())
                    node.remove();
            }
        }
        System.out.println(document.toString());