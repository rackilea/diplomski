try {
            Document doc = Jsoup.connect("http://popofibo.com/pop/swaying-views-of-our-past/").get();
            Elements paragraphs = doc.select("p");
            for(Element p : paragraphs) {
              System.out.println(p.text());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }