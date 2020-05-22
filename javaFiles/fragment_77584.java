@RequestMapping(value = "/saveParent", method = RequestMethod.POST)
    public String saveParent(CommandName cn, BindingResult bindingResult) {
        Parent parent = cn.Parent();
        List existChildren = cn.getExistingChildren();
        for (Child c : existChildren) {
            c.setParent(parent);
        }
        List newChildren = cn.getNewChildren();
        for (Child c: newChildren) {
            c.setParent(parent);
        }
        parent.getChildren().addAll(existChildren);
        parent.getChildren().addAll(newChildren);
        parentRepository.save(parent);
        return "redirect:/view";
    }