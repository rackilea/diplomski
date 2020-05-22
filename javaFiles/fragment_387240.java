if(buyOrder instanceof MarketOrder && sellOrder instanceof LimitOrder){
        return ((LimitOrder)sellOrder).getUnitPrice();
    }

    if(buyOrder instanceof LimitOrder && sellOrder instanceof MarketOrder){
        return ((LimitOrder)buyOrder).getUnitPrice();
    }