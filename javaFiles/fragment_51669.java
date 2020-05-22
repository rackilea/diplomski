@RequestMapping(value = "pages/main/detail", method = RequestMethod.GET)
public String detailProduct(final Model model, @RequestParam String id) {
    ...
}

@RequestMapping(value = "pages/main/addtocaddy", method = RequestMethod.GET)
public String addToCaddy(final Model model, @RequestParam String id,String action) {
   ...
}