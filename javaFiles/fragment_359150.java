try {
    //change path to phantomjs binary and your script file
    String phantomJSPath = "bin" + File.separator + "phantomjs";
    String scriptFile = "yahoo.js";

    Process process = Runtime.getRuntime().exec(phantomJSPath + " " + scriptFile);
    process.waitFor();

    //Jsoup
    Elements elements = Jsoup.parse(new File("yahoo.html"),"UTF-8").select("div.asset-profile-container p strong"); //yahoo.html created by script file in same path

    for (Element element : elements) {
        if(element.attr("data-reactid").contains("asset-profile.1.1.1.2")){
            System.out.println(element.text());
        }
    }

} catch (Exception e) {
    e.printStackTrace();
}