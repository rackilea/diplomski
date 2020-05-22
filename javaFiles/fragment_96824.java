new Thread( new Runnable() {
    @Override
    public void run() {
        try {
            URL url = new URL("http://tw.news.yahoo.com/rss/");
            SAXReader saxReader = new SAXReader();

            Document document = saxReader.read(url);
            Element channel = (Element) document.getRootElement().element(
                    "channel");
            for (Iterator i = channel.elementIterator("item"); i.hasNext();) {
                Element element = (Element) i.next();
                System.out.println("title: " + element.elementText("title"));

                String descrip_original = element.elementText("description");
                if (descrip_original.startsWith("<p>")) {
                    // address html-like layout
                    System.out.println(descrip_original.substring(
                            descrip_original.indexOf("</a>") + 4,
                            descrip_original.length() - 1));

                }

                System.out.println("link: " + element.elementText("link"));
                System.out
                        .println("pubDate: " + element.elementText("pubDate"));

                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} ).start();