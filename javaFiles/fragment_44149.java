public JAXBElement<IBTradeInfo> getTradeXML(){
    if(null == mTrade || mTrade.size() == 0) {
        return null;
    }
    IBTradeInfo tradeInfo = mTrade.get(0);
    QName qname = new QName("http://www.example.com", "trade-info");
    return new JAXBElement(qname, IBTradeInfo.class, tradeInfo);
}