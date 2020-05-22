Map<Class, Map<Class, IFunction>> opClass2calcAlgorithm = new HashMap();

IFunction market_market = new IFunction() {

            @Override
            public Long execute(Order a, Order b) {
                return tradeRepository.getLastPrice();
            }
        };

IFunction market_limit = new IFunction() {

            @Override
            public Long execute(Order a, Order b) {
                return ((LimitOrder)a).getUnitPrice();
            }
        };

Map<Class, IFunction> marketMap = new HashMap();
marketMap.put(MarketOrder.class, market_market);
marketMap.put(LimitOrder.class, market_limit);
opClass2calcAlgorithm.put(marketMap);