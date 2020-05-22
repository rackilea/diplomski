Elements tds = row.select("td");
count = 0; //cell location at that row
for (Element element : tds) {
    cell = header.createCell(count);            

    cell.setCellValue(element.text());
    Element href = element.select("a[href]").first();
    if (href != null){
         Hyperlink link = createHelper.createHyperlink(Hyperlink.LINK_URL);
         link.setAddress(href.attr("href"));
         cell.setHyperlink(link); 
    }
    count++;
}