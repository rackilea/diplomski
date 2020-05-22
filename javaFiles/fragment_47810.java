@ResponseBody
     @RequestMapping(value = "/jsonTable", method = RequestMethod.GET)
     public ModelAndView populateJsonTable(@ModelAttribute("model") Person model) {
        DataTables<Person> dt = new DataTables<Person>();
        Map<String, Object> result = new HashMap<String, Object>();
        Person person = new Person();
        List<Person> personList = person.findMatches(ctxt.getSession(), 1);
        dt.setEntityData(personList);
        dt.setiTotalDisplayRecords(5);
        result.put("personList", JsonUtil.toJson(dt));
        return new ModelAndView("your jsp page here e.g page/personForm", result);
     }