public void get_content(String eliment_by, String identification) {
    try {

        org.jsoup.nodes.Document doc = Jsoup.connect("http://www.opengurukul.com/vlc/mod/page/view.php?id=523").get();
        Element content = doc.getElementById(identification);

        this.current_page_content = content.html();

    } catch (IOException ex) {
        Logger.getLogger(url_looping.class.getName()).log(Level.SEVERE,
                null, ex);
    }
}