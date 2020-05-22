String url = "http://www.lazada.com.my/asus-zenfone-c-zc451cg-16gb-white-2801812.html";
Document doc = Jsoup.connect(url)
       .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:40.0) Gecko/20100101 Firefox/40.1")
       .get();
Elements description = doc.select("h2.product-description__title");
System.out.println("Description :"+description);
System.out.println("Price is " + doc.select("#pdtprice").text());