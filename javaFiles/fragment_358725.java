public void writeHtml(String[] content) {
    Path file = Paths.get("final.html");
    try (BufferedWriter fw = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
        fw.write("<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=UTF-8\">\n"
                + "<title>" + fileName + " for  The Delinquent</title>\n"
                + "<style type = \"text/css\">\n"
                + "body {font-family: \"Times New Roman, serif\";"
                + " font-size: 14 or 18; text-align: justify;};\n"
                + "p { margin-left: 1%; margin-right: 1%; }\n"
                + "</style>\n"
                + "</head><body>");
        fw.write("Content has: " + content.length + " strings.<br>\n");
        for (String k : content) {
            fw.write("* " + k + "<br>\n");
        }
        fw.write("</body></html>\n");
    } catch (IOException e) {
        System.out.println("Error " + e.getMessage());
    }
}