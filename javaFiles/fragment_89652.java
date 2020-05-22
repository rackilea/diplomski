@SuppressWarnings("unchecked")
private static Map<String, Object> getArgs(Object obj) {
    Map<String, Object> m = (Map<String, Object>) obj;
    Map<String, Object> args = new HashMap<>();
    for (Map.Entry<String, Object> x : m.entrySet()) {
        args.put(x.getKey(), x.getValue());
    }
    return args;
}

public void buildAndUpdateCustomer(List<Object> list) {
    for (Object obj : list) {
        Map<String, Object> args = getArgs(obj);
        // these are my XYZ things...
        daoProvider.updateCustomerName(args);
        daoProvider.updateAgingMia(args);
    }
}

public void buildAndUpdateTax(List<Object> list) {
    for (Object obj : list) {
        Map<String, Object> args = getArgs(obj);
        daoProvider.updateTaxAmount(args);
    }
}

public void buildAndUpdateLedgerBal(List<Object> list) {
    for (Object obj : list) {
        Map<String, Object> args = getArgs(obj);
        daoProvider.updateLedgerBalance(args);
    }
}