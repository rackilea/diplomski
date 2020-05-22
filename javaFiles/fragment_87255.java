Document doc = Jsoup.parse("<span id=\"result_box\" class=\"short_text\" lang=\"es\">\n" +
                "  <span class=\"hps\">\n" +
                "    hello\n" +
                "  </span>\n" +
                "  <span class=\"hps\">\n" +
                "    world\n" +
                "  </span>\n" +
                "</span>");

    System.out.println(doc.html());

    Elements els = doc.select("span.hps");
    for(Element e:els){
        System.out.print(e.text());
    }