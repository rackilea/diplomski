public static void main(String[] args) throws IOException {

Document doc = Jsoup.connect("http://www.fidalservizi.it/risultati/Izmir_2014/Gara053.htm").get();

Elements table = doc.select("tr:gt(0)").not("td#t1_ckrs.td_fine");
for (Element row : table) {

  if (isDataRow(row)) {
    System.out.print(" Pos :" + row.getElementById("t1_clas").text());
    System.out.print(" Name :" + row.getElementById("t1_atle").text());
    System.out.println(" Country " + row.getElementById("t1_soci").text());
  }
 }
}

private static boolean isDataRow(Element row){
  Elements elements = row.select("tr.due");
  elements.addAll(row.select("tr.uno"));
  return !elements.isEmpty() && !elements.text().equalsIgnoreCase("");
}