StringBuilder html = new StringBuilder();
java.net.URL url = new URL("http://www.google.com/");
BufferedReader input = null;
try {
    input new BufferedReader(
        new InputStreamReader(url.openStream()));

    String htmlLine;
    while ((htmlLine=input.readLine())!=null) {
        html.appendLine(htmlLine);
    }
}
finally {
    input.close();
}

Pattern exp = Pattern.compile(
    "<meta name=\"generator\" value=\"([^\"]*)\" />");
Matcher matcher = exp.matcher(html.toString());
if(matcher.find())
{
    System.out.println("Generator: "+matcher.group(1));
}