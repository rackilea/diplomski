@PostMapping("/doSearch")
 public String doActions(@ModelAttribute StockQuote stockQuote, Model 
 theModel, @ModelAttribute("searchText") String symbol) throws 


IOException {

  List<StockQuote> theQuote = 
  stockQuoteService.searchQuotes(symbol);
  theModel.addAttribute("stockQuote", theQuote);

  return "search";

 }