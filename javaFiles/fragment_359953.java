@RequestMapping(value = "/productdetail/{id}", method = RequestMethod.GET)
public String productDetail(@PathVariable("id") Long serviceId) {

    Optional<Service> service = repository.findById(serviceId);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("service", service);

    System.out.println("teste: " + serviceId);

    return "productdetail";
}