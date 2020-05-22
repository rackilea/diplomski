Thread threadNet = new Thread() {
  public void run() {
    Document doc;
    try {
      doc = Jsoup.connect("https://www.amazon.com/s/ref=nb_sb_ss_c_1_6?url=search-alias%3Daps&field-keywords=rx+390&sprefix=rx+390%2Caps%2C166&crid=2MTUBA4KGNY06").get();
      String link= doc.select("div.searchTemplate.listLayout.so_us_en")
                .select("div[id= topDynamicContent]")
                .select("div.a-row.a-spacing-base.searchUndoAUIHacks")
                .select("div.a-row")
                .select("div.a-column.a-span8.a-spacing-none")
                .select("div.s-first-column")
                .select("h2.a-size-base.a-spacing-small.a-spacing-top-small.a-text-normal").first().text();
          System.out.print(link);
    } catch (IOException e) {
          e.printStackTrace();
    }
  }
};
threadNet.start();