public class WebDownloadThreadHandler implements Runnable {
        private String link;
        private String validUrl;
        private Semaphore barrier;

        public ScopusThreadHandler(String link, String validUrl, Semaphore barrier) {
            this.link = link;
            this.validUrl = null;
            this.barrier = barrier;
        }

        public void run () {
            try {
                Document document = Jsoup.connect(this.link).userAgent("Mozilla/5.0");
                Elements elements = document.select(YOUR CSS QUERY);

                /*
                YOUR JSOUP CODE GOES HERE, AND STORE THE VALID URL IN: this.validUrl = THE VALUE YOU GET;
                */

            } catch (IOException) {
                e.printStackTrace();
            }

            this.barrier.release();
      }
}