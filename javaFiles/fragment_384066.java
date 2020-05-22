String subject = "Ed Sheeran";
URL url = new URL("https://en.wikipedia.org/w/index.php?action=raw&title=" + subject.replace(" ", "_"));
String text = "";
try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()))) {
    String line = null;
    while (null != (line = br.readLine())) {
        line = line.trim();
        if (!line.startsWith("|")
                && !line.startsWith("{")
                && !line.startsWith("}")
                && !line.startsWith("<center>")
                && !line.startsWith("---")) {
            text += line;
        }
        if (text.length() > 200) {
            break;
        }
    }
}
System.out.println("text = " + text);