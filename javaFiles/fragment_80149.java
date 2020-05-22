// just displays the form
@RequestMapping(value = "/payPal2", method = RequestMethod.GET)
public String payByCreditCardGet(@ModelAttribute("orderContext") OrderContext orderContext, Model model) throws Exception {
    // orderContext is "empty", just need to return the JSP path to the form
    return "paypal/index"; // for example
}

// receives the form
@RequestMapping(value = "/payPal2", headers = "Accept=application/json", method = RequestMethod.POST)
public @ResponseBody Payment payByCreditCardPost(@ModelAttribute("orderContext") OrderContext orderContext, Model model) throws Exception {
    // form is submitted, orderContext is set depending on the form entries
}