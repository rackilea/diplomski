String URL = "http://bola.kompas.com/ligaindonesia";
Connection.Response response = Jsoup.connect(URL)
        .userAgent("Mozilla/5.0")
        .timeout(0).execute();
int statusCode = response.statusCode();
if(statusCode == 200){
    Document dok = Jsoup.parse(response.body(),URL);
    System.out.println("opened page: "+ URL);

    //your stuff

}