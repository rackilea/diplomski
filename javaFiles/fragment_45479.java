String[] urls = { 
        "http://www.randomwebsite1/home.html",
        "https://sites.google.com/a/organization/contact-us", 
        "http://www.alright.com/index.html",
        "http://www.youtube.com/" 
};

Document doc = null;
for (String url : urls) {
    doc = Jsoup.connect(url).get();
}