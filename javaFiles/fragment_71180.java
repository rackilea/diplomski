while (res.next()){
       .......
       .......
       String baseUrl = "http://www.imdb.com/search/title?release_date=" + ""
                + year + "," + year + "&title=" + movieName + ""
                + "&title_type=feature,short,documentary,unknown";
       Connection con = Jsoup.connect(baseUrl).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21").timeout(10000);
       Connection.Response resp = con.execute();
       Document doc = null;
        if (resp.statusCode() == 200) {
            doc = con.get();
                    ....
        }