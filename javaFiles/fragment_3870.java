public List<ResultantDTO> convert(List<Transaction> transactions) {
    return transactions.stream().collect(
            collectingAndThen(
                groupingBy(
                        Transaction::getAccountType,
                        collectingAndThen(toList(), ResultantDTO::new)),
                map -> new ArrayList<>(map.values())));
}