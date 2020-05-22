@RequestMapping(value="/indexBackingUrl", method = RequestMethod.POST)
    public String handleNextPost(ModelMap map, HttpServletRequest request,
            @ModelAttribute("indexBacking") IndexBacking bo, BindingResult result) {

        System.out.println(bo);
        return "redirect:/someOtherUrl";
    }