Executor ex = Executors.newFixedThreadPool(3);
    String lstUrls = "http://www.java2s.com/Tutorials/Java/Scala/index.htm\n"
            + "http://www.java2s.com/Tutorials/Java/Scala/0020__Scala_Variables.htm\n"
            + "http://www.java2s.com/Tutorials/Java/Scala/0040__Scala_Variable_Declarations.htm\n"
            + "http://www.java2s.com/Tutorials/Java/Scala/0060__Scala_Semicolons.htm\n"
            + "http://www.java2s.com/Tutorials/Java/Scala/0080__Scala_Code_Blocks.htm\n"
            + "http://www.java2s.com/Tutorials/Java/Scala/0090__Scala_Comments.htm\n"
            + "http://www.java2s.com/Tutorials/Java/Scala/0100__Scala_Type_Hierarchy.htm\n";
    String[] urls = lstUrls.split("\n");
    for (final String url : urls) {
        try {
            ex.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Document doc = Jsoup
                                .connect(url)
                                .userAgent(
                                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                                .get();
                        Elements select = doc.select("div.row");
                        String html = select.html();
                        System.out.println(html);
                        /*
                         * insert html to database
                         */
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }