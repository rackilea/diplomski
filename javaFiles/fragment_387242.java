public Long getUnitPrice(Order buyOrder, Order sellOrder){

    long ret = 0L;

    Map<Class, IFunction> firstLevel = opClass2calcAlgorithm.get(buyOrder.getClass());
    if(firstLevel == null) return ret;
    IFunction calcAlg = firstLevel.get(sellOrder.getClass());
    if(calcAlg == null) return ret;

    ret = calcAlg.execute(buyOrder, sellOrder);

    return ret;
}