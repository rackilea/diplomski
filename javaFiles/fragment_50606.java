public static void main (String [] args) throws IOException{        
    Document doc = Jsoup.connect("http://www.vremea.net/Vremea-in-Arad-judetul-Arad/prognoza-meteo-pe-7-zile").get();
    Elements tds = doc.select("table.tableforecast tbody tr td.cell.large");
    for (Element e : tds){
        System.out.println(e.text());
    }
}