@RequestMapping("slide/{id}")
public String goToSlide(@PathParam("id") String id, ModelMap model) {
    model.adAttribute("slide", slideService.findById(id));
    return "slides/slide";
}

@RequestMapping("all")
public String getAllSlides() {
    return "slides/all";
}

@RequestMapping(value="slideshow/{id}", method=RequestMethod.GET)
public String getSlideshow(@PathParam("id") String slideshowId, ModelMap model) {
    model.attAttribute("slideshow", slideshowService.findById(slideshowId));
    return "slides/slideshow";
}

@RequestMapping(value="slideshow", method=RequestMethod.POST)
public String postSlideshow(@QueryParam("slideId") String slideId) {
    if(slideId != null) {
        return "slide/" + slideId;
    }
    return "redirect:all";
}