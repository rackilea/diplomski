MyStrategy strategy = strategyMap.get(purpose);
if(strategy!=null) {
    strategy.execute();
}
else {
    //handle error here
}