StringBuilder sb = new StringBuilder();
Elements paragraphs = doc.select("p:has(span.v)");
for (Element p : paragraphs) {
    sb.append(p.ownText() + "\n");
}
System.out.println(sb);