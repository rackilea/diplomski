Document doc;
{
        try{
            doc = Jsoup.connect("https://www.olx.in/lucknow/sale/?search%5Bdescription%5D=1&view=galleryBig").get();  
             Elements img = doc.select("div.mheight.tcenter img.fleft.rel.zi2");
         for(Element src : img){
             System.out.println("\nimg : " + src.attr("src"));
         }

         Elements links = doc.select("div.clr > h4.normal.large.lheight24 > a[href]");  
         for (Element link : links) { 
             String classname = link.className().toString();
                    if(classname.contains("link linkWithHash detailsLinkPromoted linkWithHashPromoted")){
                       System.out.println("pro: yes " );
                    }

                   System.out.println(classname);
                   System.out.println("\nlink : " + link.attr("href"));
                   System.out.println("text : " + link.text());  

         }


         Elements price = doc.select("div.clr > p.price.x-large strong.c000");
         for (Element getprice: price){
             System.out.println("\nPrice : " + getprice.text());
         }

         Elements typeandplace = doc.select("p.lheight18.color-1.margintop8");
         for (Element gettypeplace : typeandplace){
             System.out.println(" \nPlace : " + gettypeplace.text());  
         }



        } catch (IOException e) {
            e.printStackTrace();
        }



}