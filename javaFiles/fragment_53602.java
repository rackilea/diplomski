String[] tags = new String[]{"html", "div"};
Document thing = Jsoup.parse("<html><customTag><div>dsgfdgdgf</div></customTag><123456789/><123><html123/></html>");
for (String tag : tags) {
    for (Element elem : thing.getElementsByTag(tag)) {
        elem.parent().insertChildren(elem.siblingIndex(),elem.childNodes());
        elem.remove();
    }
}
System.out.println(thing.getElementsByTag("body").html());