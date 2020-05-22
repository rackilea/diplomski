message.getAllHeaderLines();
for (Enumeration<Header> e = message.getAllHeaders(); e.hasMoreElements();) {
    Header h = e.nextElement();
    h.getName();
    h.getValue();
}