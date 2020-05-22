Document doc = null;
    Elements aEles = null;

    try {
        // doc = Jsoup.connect("http://www.polyvore.com/bags/shop?category_id=35").get();

        doc = Jsoup.connect("http://www.polyvore.com/bags/shop?category_id=35")
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36")
                .referrer("http://www.google.com").get();

        if (doc != null) {
            aEles = doc.select("div.title > a");

            if (aEles != null)
                System.out.println("size: " + aEles.size());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }