public static void main(String[] args)
{
    try
    {
        Document doc = Jsoup
                .connect("http://champion.gg/statistics/")
                .userAgent(
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                .get();
        System.out.println(doc.toString());
        Elements table = doc.select("script");
        Element script = table.get(11);
        parseText(script);
    }
    catch (IOException exception)
    {

    }
}

public static void parseText(Element script)
{
    String text = ((DataNode) script.childNode(0)).toString().trim();
    int index = text.indexOf("_id");
    while (index > 0)
    {
        index += 6;// Beginning of value
        int endQuote = text.indexOf("\"", index);
        String id = text.substring(index, endQuote);
        index = text.indexOf("\"key\":\"", endQuote);
        endQuote = text.indexOf("\"", index + 8);
        String key = text.substring(index, endQuote);
        index = text.indexOf("\"kills\":", endQuote);
        endQuote = text.indexOf(",", index);
        String kills = text.substring(index, endQuote);
        text = text.substring(endQuote);
        index = text.indexOf("_id", index);
        System.out.println(id + key + kills);
    }
}