@RequestMapping("/list")
    public String list(ModelMap modelMap) {
            // ... do foo

             modelMap.addAttribute("greeting", "hello");

        return viewName;
    }