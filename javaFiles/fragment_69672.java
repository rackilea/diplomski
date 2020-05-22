Document doc = Jsoup.connect("http://mechanicaldesign.asmedigitalcollection.asme.org/article.aspx?articleid=1897362")
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6").get();
        Elements all = doc.select("#scm6MainContent_lblAuthors");
        Elements els = all.first().children();

        for (int i = 0; i < els.size(); i++) {
            Element el = els.get(i);
            if ("a".equals(el.tagName())) {
                if (i + 1 < els.size() && "a".equals(els.get(i + 1).tagName())) {
                    System.out.println(el.text());
                }
            }

        }