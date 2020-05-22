XML xml = new XMLDocument(new StreamSource(reader));
System.out.printf(
    "rise=%s, set=%s%n",
    xml.xpath("/weatherdata/sun/@rise").get(0),
    xml.xpath("/weatherdata/sun/@set").get(0)
);