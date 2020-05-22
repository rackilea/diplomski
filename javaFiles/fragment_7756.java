Document doc = Jsoup.parse(
    "<a href=\"/w-pustyni-i-w-puszczy-sienkiewicz-henryk,prod14290034,ksiazka-p\" " +
        "class=\"img seoImage\" " +
        "title=\"W pustyni i w puszczy &nbsp;-&nbsp;Sienkiewicz Henryk\" " +
        "rel=\"nofollow\" " +
        "data-product-id=\"prod14290034\"> " +
        "<img class=\"lazy\" src=\"/b/mp/img/svg/no_picture.svg\" lazy-img=\"https://ecsmedia.pl/c/w-pustyni-i-w-puszczy-p-iext43240721.jpg\" alt=\"\"> </a>\n"
);

String dataProductId = doc.select("a").first().attr("data-product-id");