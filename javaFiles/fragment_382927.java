String imageURL;

if(post == null || post.select(".separator img[src]").isEmpty())
    imageURL = "http://img27.imageshack.us/img27/1209/k0ve.jpg";
else
    imageURL = post.select(".separator img[src]").first().attr("src");