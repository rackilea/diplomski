Document doc = Jsoup.parse(html);
  Elements e = doc.getElementsByTag("body");            
  Log.i("Span element: "+e.get(0).nodeName(), ""+e.get(0).nodeName());
  e = e.get(0).getElementsByTag("span");
  Attributes styleAtt = e.get(0).attributes();
  Attribute a = styleAtt.asList().get(0);           
  if(a.getKey().equals("style")){
     String[] items = a.getValue().trim().split(";");
     String newValue = "";
     for(String item: items){

         if(item.contains("COLOR:")||item.contains("FONT-SIZE:")){
             Log.i("Style Item: ", ""+item);
             newValue = newValue.concat(item).concat(";");
         }
     }
     a.setValue(newValue);
     Log.i("New Atrrbute: ",""+newValue);                    
  }

  Log.i("FINAL HTML: ",""+e.outerHtml()); 

  doc.html(e.outerHtml());
    }