// for illustration only
class S3Object {
    String id;
}

// for illustration only
class S3Downloader {

    public S3Object download(String url) {
        int min = 2;
        int max = 5;
        Random rand = new Random();
        int random = rand.nextInt((max - min) + 1) + min;

        try { Thread.sleep(1000 * random); } catch (Exception ex) {}
        S3Object result = new S3Object();
        result.id = url;
        return result;
    }
}