public static void jsoup() throws IOException{
    File input = new File("C:\\users\\uzochi\\desktop\\html.html");
    Document doc = Jsoup.parse(input, "UTF-8");
    Elements es = doc.select("FONT");//select tag 
    for(Element e : es){
        System.out.println(e.text());
    }    
}