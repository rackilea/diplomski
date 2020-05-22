static class Item {
    String title;
    String link;
    String description;
}

static class Page {
    String title;
    String link;
    String description;
    String language;
    List<Item> items;
}

public static void main(String[] args) throws Exception {

    String json = readUrl("http://www.javascriptkit.com/"
                          + "dhtmltutors/javascriptkit.json");

    Gson gson = new Gson();        
    Page page = gson.fromJson(json, Page.class);

    System.out.println(page.title);
    for (Item item : page.items)
        System.out.println("    " + item.title);
}