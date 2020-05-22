final Document page = Jsoup
            .connect("http://d.eredmenyek.com/x/feed/d_hh_nBPiuHF3_hu_1")
            .cookie("_ga", "GA1.2.1639955025.1491211513")
            .referrer("http://d.eredmenyek.com/x/feed/proxy-local")
            .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
            .header("X-Fsign", "SW9D1eZo")
            .header("X-GeoIP", "1")
            .header("X-Requested-With", "XMLHttpRequest")
            .get();

    for (Element game : page.getElementsByClass("head_to_head").first().getElementsByTag("tr")) {
        System.out.println("----------------------------------------------------");
        System.out.println(game.text());

        Elements list = game.getElementsByClass("form-bg-last");
        if (!list.isEmpty()) {
            System.out.println("Title : " + list.first().attr("title"));
        }
    }