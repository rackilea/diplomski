// Get a video entry
String str = "http://gdata.youtube.com/feeds/api/videos/" + videoId;
YouTubeQuery youtubeQuery = new YouTubeQuery(new URL(str));
String videoEntryUrl = youtubeQuery.getUrl().toString();
VideoEntry videoEntry = service.getEntry(new URL(videoEntryUrl),VideoEntry.class);

// Get the comments url for this video
if (videoEntry.getComments() != null) {
    String commentUrl = videoEntry.getComments().getFeedLink().getHref();
    System.out.println(commentUrl);

    // Get the comment feed; use a new query
    YouTubeQuery youtubeQuery = new YouTubeQuery(new URL(commentUrl);
    youtubeQuery.setMaxResults(50);


    youtubeQuery.setStartIndex(1);
    String commentUrlFeed = youtubeQuery.getUrl().toString();
    CommentFeed commentFeed = service.getFeed(new URL(commentUrlFeed),CommentFeed.class);
    // The response should contain an url for the next feed, if any, already with an updated start-index.

    for (int i = 0; i < commentFeed.getEntries().size()
            && commentFeed.getEntries().get(i) != null; i++) {

        String author=commentFeed.getEntries().get(i).getAuthors().get(0).getUri().substring(41)
        String commentId=commentFeed.getEntries().get(i).getId().substring(47);
        String comment=commentFeed.getEntries().get(i).getPlainTextContent();
        }
    }
    // Loop thru next comment feed call, if more can be expected.
    // Use updated url from the response or set start-index = start-index + max-results.
 }