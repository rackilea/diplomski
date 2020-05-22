try {
       File f = new File("help/lotto.html");
       URI uri = f.toURI();
       Desktop desktop = Desktop.getDesktop();
       desktop.browse(uri);
} catch (Exception ex) {
       System.out.println("Help file was not found");
}