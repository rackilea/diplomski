for (String link : links) {
    String validUrl = null;
    taskThread = new Thread( new WebDownloadThreadHanlder(link, validUrl, barrier));
    taskThread.start();

    if (validUrl != null) {
        allUrlsOfDomain.add(validUrl);
    }
}

barrier.acquireUninterruptibly(links.size());