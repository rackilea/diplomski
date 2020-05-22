Document doc = Jsoup.connect("https://www.aboutyou.de/frauen/accessoires/huete-und-muetzen/caps?pl=1")
            .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0")
            .get();
    Elements result = doc.body().select("main#app");
    for(Element el : result) {
        Elements e = el.select("section.layout_11glwo1-o_O-stretchLayout_1jug6qr > " +
                "div.content_1jug6qr > " +
                "div.container > " +
                "div.mainContent_10ejhcu > " +
                "div.productStream_6k751k > " +
                "div > " +
                "div.wrapper_8yay2a > " +
                "div.col-sm-6.col-md-4 > " +
                "div.wrapper_1eu800j > " +
                "div > " +
                "div.categoryTileWrapper_e296pg > " +
                "a.anchor_wgmchy > " +
                "div.details_197iil9 > " +
                "div.meta_1ihynio > " +
                "div.finalPrice_11ythok > " +
                "span.price_1543wg1");
        System.out.println(e.text());
    }