@PostMapping(value = "/values/fiatCurrency")
public String choseCurrency(Model model,
                            @ModelAttribute Fiat fiat) {
    //..
    return "index";
}