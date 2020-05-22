Document doc = Jsoup.parse("<td class=\"text_bold text_align_left\" valign=\"top\" width=\"150\">example</td><td class=\" text_bold\">example</td>");
        Elements elms = doc.select("td.text_bold");
         for(Element e:elms)
             if(e.className().trim().equals("text_bold")) 
             {
                 System.out.println(e.className());

             }