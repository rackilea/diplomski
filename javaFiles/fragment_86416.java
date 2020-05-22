@Autowired 
private CreateEntitiesDao createentitiesdao;

  @RequestMapping(value = { "/CreateEntity" }, method = RequestMethod.GET)  
  public ModelAndView CreateEntity(@RequestParam(defaultValue="",required=false)String module,Model model) {  
      model.addAttribute("module", module);  
     // module = module== null ? "": module;
      if(module.equals("leadstatus"))
      {
          model.addAttribute("pgtitle", "Lead Status");
          model.addAttribute("viewpg", "CreateLeadStatus.jsp");
          model.addAttribute("controllername", "Connroller name");
      }
      else if(module.equals("account"))
      {
          model.addAttribute("pgtitle", "Account");
          model.addAttribute("viewpg", "account.jsp");
          model.addAttribute("controllername", "Connroller name");
      }

      return new ModelAndView("CreateEntity");
  }