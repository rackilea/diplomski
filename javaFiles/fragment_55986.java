Map<Long, BigDecimal> collect = accounts.stream()
        .flatMap(account -> account.getList().stream())
        .flatMap(subAccount -> subAccount.getList().stream())
        .collect(Collectors.groupingBy(asset -> Long.valueOf(asset.getAssetId()),
                Collectors.reducing(
                        BigDecimal.ZERO,
                        Assets::getQuantity,
                        BigDecimal::add
                )
        ));