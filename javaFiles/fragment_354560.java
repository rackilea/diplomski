@RequestMapping(value = "/product", params = "size", method = RequestMethod.GET)
public String getProduct(@RequestParam String size, Model model){
    if ("s".equals(size)) {
        // add small product to model
    } else if ("m".equals(size)) {
        // add medium product to model
    }
    ....
    return "...";
}