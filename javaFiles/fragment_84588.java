Document doc = Jsoup.parseBodyFragment(html);  
Elements title = doc.select("div[class=Title]");  
Elements art = doc.select("div[class=Art]");  
Elements location = doc.select("div[class=Ort]");  
Elements price = doc.select("div[class=Preis]");  
Elements size = doc.select("div[class=Groesse]");  
Elements numberOfRooms = doc.select("div[class=Zimmer]");  
Elements furtherProperties = doc.select("div[class=EigListe]");  

//for price  
  Int i;  
  for (i=0; i < element.length; i++) {  
        if(element[i] != null){  
          priceList.add(element.text().toString());  
        }else{
          priceList.add("null/undef/whatever");
        }
  }