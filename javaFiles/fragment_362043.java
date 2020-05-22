GoogleService myService = new GoogleService("blogger", "exampleCo-exampleApp-1");
        myService.setUserCredentials("EMAIL", "PWD");
        Entry myEntry = new Entry();
        myEntry.setTitle(new PlainTextConstruct("TITLE post update"));
        myEntry.setContent(new PlainTextConstruct("STATUS POST"));
        URL feedUrl = new URL("http://www.blogger.com/feeds/default/blogs");
        Feed resultFeed = myService.getFeed(feedUrl, Feed.class);
        String blog_name = "blog_name"; //the name of the blog where you want to post status
        String BLOG_ID = "";
        for (int i = 0; i < resultFeed.getEntries().size(); i++) {
            Entry entry = resultFeed.getEntries().get(i);
            if (entry.getTitle().getPlainText().equalsIgnoreCase(blog_name)) {
                String[] split = entry.getId().split("-");
                BLOG_ID = split[split.length - 1];
            }
            System.out.println("Posting to:" + " " + "Blog id: " + BLOG_ID + " " + "Blog name: " + blog_name);
        }
        URL postUrl = new URL("http://www.blogger.com/feeds/" + BLOG_ID + "/posts/default");
        Entry insert = myService.insert(postUrl, myEntry);
        System.out.println(insert.getHtmlLink().getHref());