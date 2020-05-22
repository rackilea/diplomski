public static void main(String[] args) throws IOException {
    final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_60);
    webClient.getOptions().setThrowExceptionOnScriptError(false);

    final List<String> list = new ArrayList<>();

    new WebConnectionWrapper(webClient) {
        @Override
        public WebResponse getResponse(final WebRequest request) throws IOException {
            final WebResponse response = super.getResponse(request);
            list.add(request.getHttpMethod() + " " + request.getUrl());
            return response;
        }
    };

    webClient.getPage("https://www.upwork.com/o/jobs/browse/?q=Java&sort=renew_time_int%2Bdesc");
    webClient.waitForBackgroundJavaScript(10_000);
    list.forEach(System.out::println); 
}