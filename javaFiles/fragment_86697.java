trade.stream()
            .map(trade -> {
                TradeBuilder tb = Trade.newBuilder()
                    .setType(trade.type())              
                    .setUnit(trade.unit());
                if(trade.counterParty() != null) tb.setCounterParty(trade.counterParty());
                return tb.build();
             })
            .iterator();