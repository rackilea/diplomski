Collections.sort(l, new Comparator<OrderType>() {

        @Override
        public int compare(OrderType o1, OrderType o2) {
            return Integer.compare(oT1.getPriority(), oT2.getPriority());
        }
    });