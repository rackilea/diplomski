Document doc = Jsoup.connect(url).get();



 Elements divElements = doc.getElementsByTag("div");
         for(Element divElement : divElements){
             if(divElement.attr("class").equals("animal-info")){
                 textList.add(divElement.text());

                text = textList.toString();
                Log.e("Content", text);

             }