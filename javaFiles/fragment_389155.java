try {

    ArrayList<String> arr = new ArrayList<String>();

    Document page = Jsoup.connect("http://illtellyoulater.com/div.txt").get();

    Elements posts = page.getElementsByAttributeValueStarting("id", "post_id_");

    for(Element post : posts) {
        if( post.getElementsByAttributeValue("itemprop", "creator name").get(0).text().trim().equals("djrajio") ) {
            arr.add(post.getElementsByAttributeValue("itemprop","commentText").get(0).text());
        }
    }


    System.out.println(arr.toString());
}catch(Exception e) {
    e.printStackTrace();
}