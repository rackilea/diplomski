for(Element link:document.select("a[href]")) {
    String link1 = link.toString();
    String link2 = link1.substring(link1.indexOf('/'));
    String link3 = link2.substring(0, link2.indexOf('"'));

    aktien.add(link3);
}
System.out.println(aktien);