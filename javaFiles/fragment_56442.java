public class Finder {
public static void main(String[] args) {
    new Finder(
            "http://www.allmenus.com/ny/new-york/250087-forlinis-restaurant/menu/");
}

public Finder(String url) {
    Document doc1 = null;
    try {
        doc1 = Jsoup
                .connect(url)
                .userAgent(
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36")
                .referrer("http://www.google.com").get();
    } catch (IOException e) {
        System.out.println("Can't connect to website");
    }
    Elements elements = doc1.select(".category");
    HashMap<String, ArrayList<List<String>>> menu = new HashMap<String, ArrayList<List<String>>>();
    for (Element e : elements) {
        String name = e.select(".category_head>h3").first().text();
        Elements itms = e.select("ul > li");
        ArrayList<List<String>> menuItems = new ArrayList<List<String>>();
        for (Element it : itms) {
            menuItems.add(Arrays.asList(new String[] {
                    it.select("span").first().text(),
                    it.select("span").eq(1).text() }));
        }
        menu.put(name, menuItems);

    }
    for (String key : menu.keySet()) {
        System.out.println(key);
        ArrayList<List<String>> lst = menu.get(key);
        for (List<String> item : lst) {
            System.out.println("       " + item.get(0) + " " + item.get(1));
        }
        System.out.println("\n");
    }
}
}