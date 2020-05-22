@RequestMapping(value = "/saveParent", method = RequestMethod.POST)
    public String saveParent(CommandName cn, BindingResult bindingResult) {
        Parent parent = cn.getParent();
        if(parent.getId()!=null)//if parent id is not null, then retrieve the parent from database. and update it.
            parent = parentRepository.findOne(cn.getParent().getId());
        for(Child c : cn.getNewChildren()){
            c.setParent(parent);
            parent.getChildren().add(c);
        }
        parentRepository.save(parent);
        return "redirect:/view";
    }