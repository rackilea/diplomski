Document doc = Jsoup.connect("http://www.extrastores.com/ar-sa/Promotions/Recommended-Smart-phones-25038?Sort=2").get();

for( Element e : doc.select("img#eXtraContentPlaceHolder_BestNewGrid1_DataList1_BestSellerImage_0") )
{
    System.out.println(e);
}