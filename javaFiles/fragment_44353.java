Jsoup.connect("https://www.google.com.au/search?q=fred").get()
    .select("h3.r").select("a")
    .stream()
    .limit(5)
    .map(l -> l.attr("href"))
    .forEach(System.out::println);