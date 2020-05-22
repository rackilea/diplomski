// Get the first td element that has class="lastpost"
Element lastPost = document.select("td.lastpost").first();
// Get the first a element that is a child of the td
Element linkElement = lastPost.getElementsByTag("a").first();

// This text is the first child node of td, get that node and call toString
String text = lastPost.childNode(0).toString();
// This is the text within the a (link) element
String textNo = linkElement.text();
// This text is the href attribute value of the a (link) element
String link = linkElement.attr("href");