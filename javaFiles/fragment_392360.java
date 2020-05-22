try {
    //...
} catch (Exception e) {
    try(Writer w = new FileWriter("file.log", true)) {
        e.printStackTrace(new PrintWriter(new BufferedWriter(w)));
    }
}