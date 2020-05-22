Iterator<BigDecimal> it = transactionLogMap.keySet().iterator();//changed for syntax correctness
while (it.hasNext()) {
    BigDecimal bigDecimal = it.next();
    if(!inScopeActiveRegionIdSet.contains(bigDecimal)) {
        it.remove();
    }
}