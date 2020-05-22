@RequestMapping(value = "/compplan", method = RequestMethod.GET)
    public String listRules1(ModelMap model) {
        CompArray obj1 = new CompArray();
        model.addAttribute("listRule1", obj1);
        return "hello";
    }