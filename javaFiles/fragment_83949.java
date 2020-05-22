Document doc = Jsoup.connect("http://www.imdb.com/title/tt0800369/").get();

Element rating = doc
        .select("div.star-box.giga-star > div.titlePageSprite.star-box-giga-star")
        .first();

System.out.println(rating);