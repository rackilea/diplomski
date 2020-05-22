@RequestMapping(value = "/productdetail/{id}", method = RequestMethod.GET)
public String productDetail(@PathVariable("id") Long serviceId, Model model) {

    Service service = repository.getFirstById(serviceId);

    model.addAttribute("service", service);

    System.out.println("teste: " + serviceId);

    return "productdetail";
}