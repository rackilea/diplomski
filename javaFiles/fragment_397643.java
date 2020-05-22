for (int i = 1 ; i <= amount ; i++) {
    String printername = (rangen.getnumlet(length) + ".java");
    String name = printername.substring(0, printername.indexOf('.')).trim();

    try {
        tofile = new PrintWriter(printername);
        ...
    }
}