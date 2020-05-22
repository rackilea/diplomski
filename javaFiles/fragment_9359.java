@PostMapping("/postCurrency")
  public String postExchange(@RequestParam Double fNumber , Model model){
    Double number = exchangeLogic.exchange(fNumber);
    model.addAttribute("resultNumber",number);
    return "exchange";//your html page
}