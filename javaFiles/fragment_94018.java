String str3 = null;
Document doc = Jsoup.parse(responseStr);
Elements elems = doc.select("div");
for (Element elem : elems) {
    if (elem.attr("class").equals("alert alert-alert")) {
        str3 = elem.text();
    }
}
Log.d("POST", "Response " + responseStr);
Log.d("POST2", "Response " + str3);
Log.d("POST1", "Response "
+ response.getStatusLine().toString());