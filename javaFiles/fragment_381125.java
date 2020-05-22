nodelist = doc.getElementsByTagName("city_insert");
for (Element element : nodelist) {
   Element parent = element.getParentNode()
   parent.setAttribute("city_id", "123");
   parent.setAttribute("city_name", "São Paulo");
}