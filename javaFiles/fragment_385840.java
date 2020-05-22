String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36";
String reviewApiCall = "https://www.flipkart.com/api/3/product/reviews?productId=MOBEFM5HAFRNSJJA&count=15&ratings=ALL&reviewerType=ALL&sortOrder=MOST_HELPFUL&start=";
String xUserAgent = userAgent + " FKUA/website/41/website/Desktop";
String referer = "https://www.flipkart.com/moto-x-play-with-turbo-charger-white-16-gb/product-reviews/itmefzwvdejejvth?pid=MOBEFM5HAFRNSJJA";
String host = "www.flipkart.com";
int numberOfPages = 2; // first two pages of results will be fetched

try {
    // loop for multiple review pages
    for (int i = 0; i < numberOfPages; i++) {
        // query reviews
        Response response = Jsoup.connect(reviewApiCall+(i*15)).userAgent(userAgent).referrer(referer).timeout(5000)
                .header("x-user-agent", xUserAgent).header("host", host).ignoreContentType(true).execute();

        System.out.println("Response in JSON format:\n\t" + response.body() + "\n");

        // parse json response
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.body().toString());
        jsonObject = (JSONObject) jsonObject.get("RESPONSE");
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");

        for (Object object : jsonArray) {
            jsonObject = (JSONObject) object;
            jsonObject = (JSONObject) jsonObject.get("value");
            System.out.println("Author: " + jsonObject.get("author") + "\thelpful: "
                    + jsonObject.get("helpfulCount") + "\n\t"
                    + jsonObject.get("text").toString().replace("\n", "\n\t") + "\n");
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}