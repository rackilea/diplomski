youtube = new YouTube.Builder(new NetHttpTransport(), JSON_FACTORY, new HttpRequestInitializer() {
        @Override
        public void initialize(HttpRequest httpRequest) throws IOException {

        }
    }).**setYouTubeRequestInitializer(new YouTubeRequestInitializer(apiKey)**.setApplicationName("youtube-cmdline-search-sample").build();