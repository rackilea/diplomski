NodeList listaResources = raiz.getElementsByTagName("resource");

int tam = listaResources.getLength();
String[] vecResources = new String[tam];

for (int i = 0; i < tam; i++) {
   Element elem = (Element) listaResources.item(i);      
   System.out.println(elem);
   vecResources[i] =  elem.getAttribute("id"); // change to id
}