String verse = "2:2";
// The span of class main located inside the table of class scripture
// that contains a td of class verse with a link whose attribute name is the value of verse
Element p = doc.select(
    String.format("table.scripture:has(td.verse a[name=%s]) span.main", verse)
).first();
System.out.println(p.text());