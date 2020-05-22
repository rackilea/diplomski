trade.stream()
            .map(trade -> {
                TradeBuilder tb = Trade.newBuilder()
                    .setType(trade.type())              
                    .setUnit(trade.unit());
                Optional.ofNullable(trade.counterParty())
                    .ifPresent(tb::setCounterParty);
                return tb.build();
             })
            .iterator();