static protected List<String> getBarschema(String URL) throws Exception {

    Document document = Jsoup.connect(URL).get();

    // New Selector
    Elements dagen = document.select("div.content table tr td");

    // List better than array in this case
    List<String> dag = new ArrayList();   

    String line = "";
    for (Element dagen1 : dagen) {                              

        String width = dagen1.attr("width");      
        if(width.equals("100%") && !line.equals("")){
            dag.add(line);
            line ="";
        }    
        line += dagen1.text() + "\n";
    }        
    return dag;
}