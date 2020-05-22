List<TXN_PMTxnHistory_rb> listHistory_rb6 = 
    listHistory_rb5.values()
                   .stream()
                   .filter(Optional::isPresent)
                   .map(Optional::get)
                   .collect(Collectors.toList());