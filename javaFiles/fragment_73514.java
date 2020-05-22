@RequestMapping("/orders/home.spr")
public String getHome(Model model) {

    List<Offer> offers = offersService.getCurrent();

    model.addAttribute("offers", offers);
    return "home";
}