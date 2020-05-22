// First, find all elements that fit your criteria
Elements links = doc.select("a.group-link-for-image");
// Then, walk through the found elements and collect the information you want
for (Element link : links) {
    System.out.println(link.attr("abs:href"));
}