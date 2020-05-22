List<DbTransResponse> result = transList.stream()
        .collect(Collectors.groupingBy(DbTrans::getAcct))
        .values().stream()
        .map(trans -> new DbTransResponse(
                trans.get(0).getName(),
                trans.get(0).getAcct(),
                trans.get(0).getTotal(),
                trans.get(1).getTotal()
        )).collect(Collectors.toList());