String src = null;

Element video = doc.select("video").first();
Element source = null;

if(video.attr("src").isEmpty()){
    System.out.println("is null");
    source = video.select("source").first();
}

if(!video.attr("src").isEmpty()){
    src = video.attr("src");
}else if(!source.attr("src").isEmpty()){
    src = source.attr("src");
}