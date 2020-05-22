if(!Desktop.isDesktopSupported()){        
    System.out.println("Desktop is not supported");
    return;
}
Desktop desktop = Desktop.getDesktop();
if (desktop.isSupported(Desktop.Action.OPEN) && pdfFilepath.exists()) {
    try {
        //desktop.open(pdfFilepath.getParentFile());
        desktop.open(pdfFilepath);
    } catch(IOException ex) {
        ...
    }
}