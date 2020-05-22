@SuppressWarnings("unchecked")
private static void buildAndUpdate(List<Object> list, Consumer<Map<String, Object>> consumer) {
    for (Object obj : list) {
        Map<String, Object> m = (Map<String, Object>) obj;
        Map<String, Object> args = new HashMap<>();
        for (Map.Entry<String, Object> x : m.entrySet()) {
            args.put(x.getKey(), x.getValue());
        }
        consumer.accept(args);
    }
}

public void buildAndUpdateCustomer(List<Object> list) {
    buildAndUpdate(list, args -> {
        daoProvider.updateCustomerName(args);
        daoProvider.updateAgingMia(args);
    });
}

public void buildAndUpdateTax(List<Object> list) {
    buildAndUpdate(list, args -> daoProvider.updateTaxAmount(args));
}

public void buildAndUpdateLedgerBal(List<Object> list) {
    buildAndUpdate(list, args -> daoProvider.updateLedgerBalance(args));
}