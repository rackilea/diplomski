Map<String, BigDecimal> collect = accounts.stream()
        .flatMap(account -> account.getList().stream())
        .flatMap(subAccount -> subAccount.getList().stream())
        .collect(Collectors.groupingBy(Assets::getAssetId,
                Collectors.reducing(
                        BigDecimal.ZERO, 
                        Assets::getQuantity,
                        BigDecimal::add)
        ));