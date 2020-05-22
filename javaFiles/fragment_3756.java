public String saveListOfMarketPrice(MarketPrice marketPrice) {
        System.out.println("In Analyser DAO fro bulk saving");
        final Session session = getSession();
        session.beginTransaction();
        for (Items item : marketPrice.marketPrices) {
           marketPrice.currentItem = item;
           session.save(marketPrice);
        }
        session.getTransaction().commit();
        session.close();
        return "success";
    }