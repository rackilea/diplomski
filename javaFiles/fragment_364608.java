private String getMerchantName(Integer id) {      
    return Optional.ofNullable(id)
        .flatMap(i -> merchantService.findById(i))
        .map(Merchants::getName)
        .orElse(<default value>);
}