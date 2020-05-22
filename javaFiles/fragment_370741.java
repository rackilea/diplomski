class TEST {
    public static void main(String arg[]){
        new TEST();
    }


    TEST(){
        try{

            String html = "<div class=\"search_test\">\n" +
                    "        <div class=\"inside_test\">\n" +
                    "        <div class=\"s_test\">\n" +
                    "            <h3 class=\"result-title\">\n" +
                    "                <span>1.<a href=\"#\">Test Company<span>IT</span></a></span>\n" +
                    "            </h3>\n" +
                    "        </div>\n" +
                    "        </div>\n" +
                    "</div>";

            String companyName = "Test Company IT";

            String comS ="";
            Document docs = Jsoup.parse(html);
            Elements div  = docs.getElementsByIndexGreaterThan(0);
            Elements d = div.first().children();//.first().children().first().children().first().children().first().children().first().children().text();
            for(int i=0; i<d.size(); i++){
                Elements sub = d.get(i).children();
                if(sub.text().equalsIgnoreCase(companyName))
                    comS = sub.get(i).tagName();
                else
                for(int i1=0; i1<sub.size(); i1++){
                    Elements sub1 = sub.get(i1).children();
                    if(sub1.text().equalsIgnoreCase(companyName))
                        comS = sub.get(i).tagName() + " " +sub1.get(i1).tagName();
                    else
                    for(int i2=0 ;i2<sub1.size();i2++){
                        Elements sub2 = sub1.get(i2).children();
                        if(sub2.text().equalsIgnoreCase(companyName))
                            comS = sub.get(i).tagName() + " " +sub1.get(i1).tagName() + " " + sub2.get(i2).tagName();
                        else
                        for (int i3=0; i3<sub2.size();i3++){
                            Elements sub3 = sub2.get(i3).children();
                            if(sub3.text().equalsIgnoreCase(companyName))
                                comS = sub.get(i).tagName() + " " +sub1.get(i1).tagName() + " " + sub2.get(i2).tagName() + " " + sub3.get(i3).tagName();
                            else
                            for(int i4=0; i4<sub3.size();i4++){
                                Elements sub4 = sub3.get(i4).children();
                                if(companyName.equalsIgnoreCase(sub4.text())){
                                    comS = sub.get(i).tagName() + " " +sub1.get(i1).tagName() + " " + sub2.get(i2).tagName() + " " + sub3.get(i3).tagName() + " "+ sub4.get(i4).tagName();
                                }


                            }

                        }
                    }
                }
            }
            System.out.println("--> st : " + comS);
            System.out.println("--> 111  " + div.select(comS).text());

        }   catch (Exception e){
            e.printStackTrace();
        }
    }

}