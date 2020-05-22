String shareBody = "";
for (i=0; i<cartList.size(); i++){
        Cart cartL = cartList.get(i);
        img = cartL.getImage();
        title = cartL.getTitle();
        market = cartL.getMarket();
        cost = cartL.getCost();
shareBody += "Ürün Adı:  " + title + "  Market:  " + market + "   Fiyat:  " + cost;}