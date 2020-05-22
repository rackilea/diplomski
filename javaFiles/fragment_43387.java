//  String html =" ...here goes your html code... ";
// Document doc = Jsoup.parse(html);
// Or from file:
    File input = new File("com.htm");
    Document doc = Jsoup.parse(input, "UTF-8");
    Elements trs = doc.select("tr"); //select all "tr" elements from document
    for(Element tr:trs){
        //Getting the class string form tr element
        System.out.println("The file class is: " + tr.attr("class") 
       //getting the filename string that holds inside td element
         + " The filamee is: "  + tr.select("td").text());
    }
}