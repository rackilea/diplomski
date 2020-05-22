Elements imgs = docs.select("img[src$=.jpg]");
for (Element img : imgs) {
    String url = img.absUrl("src");
    String newImg = "<img src=\"" + url + "\"/>";
    // ...
}