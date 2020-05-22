try {
    InputStream is = (InputStream) getClass().getResourceAsStream("/Text");
    String str = "";            
    int ch;
    while ((ch = is.read()) != -1) {
        str += (char)ch;
    }
    synchronized (UiApplication.getEventLock()) {
        Dialog.alert(str == null ? "Failed to read." : str);    
    }
} catch (Exception e) {
    synchronized (UiApplication.getEventLock()) {
        Dialog.alert(e.getMessage() + " + " + e.toString());
    }
}