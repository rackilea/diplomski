public static void main(String[] args)
{
    Document document = Jsoup.parse("<html>" +
            "  <body>" +
            "   <div id='foo'>" +
            "     <p id='bar'>TEST</p>" +
            "   </div>" +
            "  </body>" +
            "</html>");

    System.out.println("Add blah to the Element with ID: foo");
    Element foo = document.getElementById("foo");
    foo.appendText("blah");

    System.out.println(document.html());

    System.out.println("Get the content of a div having a p:");
    for (Element div : document.getElementsByTag("div"))
    {
        for (Element p : div.getElementsByTag("p"))
        {
            System.out.println(p.text());
        }

    }
}