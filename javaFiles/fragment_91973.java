try {
    Desktop dt = Desktop.getDesktop();
    dt.browse(  new URI("http://google.com/") );
} catch (URISyntaxException | IOException e) {
    e.printStackTrace();
}