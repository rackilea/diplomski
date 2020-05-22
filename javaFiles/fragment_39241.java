...
if (p != null) {
    while (true) {
        try { p.waitFor(); break; }
        catch (InterruptedException ex) { /* don't care */ }
    }

    Collection<File> files ...