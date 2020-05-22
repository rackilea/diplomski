public String getFindForm(Model model){
        model.addAttribute("enctr",new Encounter());
        return "AddLink";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String processFindForm(@ModelAttribute("enctr")Encounter encounter){
        System.out.println(encounter.getSelectedLink());    

        return "AddLink";//"redirect:"+encounter.getSelectedLink();
    }

    @ModelAttribute("addLinkOptions")
    public Map loadLinkOptions(){
        LinkedHashMap<String, String> addLinks = new LinkedHashMap<String,String>();
        addLinks.put("/thislink","New this");
        addLinks.put("/thatlink","New that");
        addLinks.put("/otherlink","New other thing");
        return addLinks;
    }