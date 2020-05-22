URL url = null;
    try {
        url = new URL("http://www.example.com");
    } catch (MalformedURLException e) {
        //Catch badly formed URL.
        e.printStackTrace();
    }
    if (url != null)
       contentsFuture = startDownloading(url);