Elements thumbs = doc.select("div.latest-media-images img.latestMediaThumb");
List<String> thumbLinks = new ArrayList<String>(); 
for(Element thumb : thumbs) {
    thumbLinks.add(thumb.attr("src"));
}
for(String thumb : thumbLinks) {
    System.out.println(thumb);
}