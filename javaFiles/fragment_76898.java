Document doc = Jsoup.connect("http://www.forbes.com/colleges/"+college+"/").get();
Elements photos = doc.select("div[id=photos]");
if(photos!=null && photos.size() > 0){                   
    imgSrc1 = photos.select("li").select("img").first().attr("src");
    input1 = new java.net.URL(imgSrc1).openStream();
    bitmap1 = BitmapFactory.decodeStream(input1);
    image1.setImageBitmap(bitmap1);
}else{
    buffer.append("No Pictures");
}