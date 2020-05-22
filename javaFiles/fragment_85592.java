view.post(new Runnable() {
    @Override
    public void run() {
        String html =   "<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "<title>APP</title>\n" +
                "</head>\n" +
                "<body style=\"background:#e11020;font-family:Arial,Helvetica;\">\n" +
                "<h1 style=\"color:rgba(255,255,255,0.9);text-align:center;padding:120px 20px 20px 20px;font-size:30px;\">No Internet connection</h1>\n" +
                "</body>\n" +
                "</html>";

        view.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
    }
});