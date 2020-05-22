<% if(products != null) { %>

   var mainResults = [
      <% for (int i=0; i<products.productsList.size(); i++) {
         Product currProd = products.productsList.get(i);
      %>

         {
            count : "<%= i %>",
            id : "<%= prodId %>",
            name : "<%= prodName %>",
            manufacturer : "<%= prodManufacturer %>",
            description : "<%= prodDescription %>",
            numretailer : "<%= prodRetailer %>",
            logo : "<%= prodLogo %>",
            logoh : "<%= prodLogoHeight %>",
            logow : "<%= prodLogoWidth %>",
            lowpriceamt : "<%= lowPriceAmount %>",
            lowpricecur : "<%= lowPriceCurrency %>",
            highpriceamt : "<%= highPriceAmount %>",
            highpricecur : "<%= highPriceCurrency %>",
            ratings : [
               <% for(int j=0; j<currProd.ratingList.size(); j++) { %>
                  {
                     count : "<%= j %>",
                     type : "<%= prodRatType %>",
                     average : "<%= prodRatAvg %>",
                     number : "<%= prodRatNum %>"
                  }
               <% if(j < (currProd.ratingList.size() - 1)) { %>
               ,
               <% } %>

               <% } %>
            ],
            retailers : [
               <% for(int x=0; x<currProd.retailerList.size(); x++) { %>
                  {
                     retailers.count : "<%= x %>",
                     id : "<%= currProd.retailerList.get(k).id %>",
                     name : "<%= currProd.retailerList.get(k).name %>",
                     purchaselink : "<%= currProd.retailerList.get(k).link %>",
                     logo : "<%= retailLogo %>",
                     leadtime : "<%= currProd.retailerList.get(k).leadTime %>",
                     stock : "<%= currProd.retailerList.get(k).stockInfo %>",
                     priceamt : "<%= currProd.retailerList.get(k).price.amount %>",
                     pricecur : "<%= currProd.retailerList.get(k).price.currency %>",
                     sourcetype : "<%= currProd.retailerList.get(k).sourceType %>",
                     sourcedate : "<%= currProd.retailerList.get(k).sourceDate %>",
                     shipminprice : "<%= minShipPrice %>",
                     shipmincur : "<%= minShipCurrency%>",
                     shipmaxprice : "<%= maxShipPrice %>",
                     shipmaxcur : "<%= maxShipCurrency %>"
                  }

                  <% if(x < (currProd.retailerList.size() - 1)) { %>
                  ,
                  <% } %>

               <% } %>
            ]
         }

         <% if(i < (products.productsList.size() - 1)) { %>
         ,
         <% } %>

      <% } %>
   ];

<% } %>