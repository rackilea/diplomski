@RequestMapping(value = "/convert", method = RequestMethod.GET, produces = "application/json")
    public ExchangeRateDTO converting(@RequestParam("fromCurrency") @NotNull @NotBlank @Size(max = 10) String fromCurrency,
                                      @RequestParam("toCurrency") String toCurrency,
                                      @RequestParam("amount") String amount) throws IOException {
        if (!Currency.getAvailableCurrencies().contains(Currency.getInstance(fromCurrency))) {

        }
        BigDecimal convertedAmount = currencyExchangeService.convert(fromCurrency, toCurrency, new BigDecimal(amount));