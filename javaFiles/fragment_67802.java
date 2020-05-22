File f=new File(".//output//Test.html");
Document doc=Jsoup.parse(f, "UTF-8");
Element element=doc.select("h1").first();
System.out.println(element.text());
element.after("<h2>TEST</h2>");
element.append("<h2>TEST</h2>");
try(PrintWriter printWriter = new PrintWriter("your-target-path")) {
    printWriter.write(doc.html());
} catch (FileNotFoundException e) {
    e.printStackTrace();
}