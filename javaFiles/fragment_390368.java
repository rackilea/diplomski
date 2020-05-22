public void getData() throws IOException {
    Document doc = Jsoup.parse(new File("path/to/html/file"), "UTF-8"); //You can parse a url also instead of file

    String text = "";
    Elements e = doc.select("td.FieldName + td");
    for (Element temp : e) {            
        text = temp.text();
        System.out.println(text);
    }
}