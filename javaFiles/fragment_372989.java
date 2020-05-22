Document doc = Jsoup
        .connect("http://www.taifex.com.tw/chinese/3/3_2_2.asp")
        .data("qtype","")
        .data("commodity_id","TXO")
        .data("commodity_id2","")
        .data("goday","")
        .data("dateaddcnt","0")
        .data("DATA_DATE_Y","2015")
        .data("DATA_DATE_M","8")
        .data("DATA_DATE_D","27")
        .data("syear","2015")
        .data("smonth","8")
        .data("sday","27")
        .post();

Element x = doc.select("h3:matches(日期)").first();
System.out.print(x.text());