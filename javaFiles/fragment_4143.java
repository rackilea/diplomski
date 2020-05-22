@GetMapping("/show")
public String show(@RequestParam ("city") String city, ModelMap modelMap){
    modelMap.addAttribute("article");

    logger.info("whatever you want "+city);

    return "article/show";
}