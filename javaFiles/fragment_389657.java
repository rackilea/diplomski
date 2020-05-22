public static void main(String[] args) {
    Document doc = Jsoup.parse(""
            + "<div>"
            + "  <a href='link1' class='title another'>Link 1</a>"
            + "  <a href='link2' class='another'>Link 2</a>"
            + "  <a href='link3'>Link 3</a>"
            + "</div>");

    Elements links = doc.select("a[href].title");
    System.out.println(links); // prints "<a href="link1" class="title another">Link 1</a>"
}