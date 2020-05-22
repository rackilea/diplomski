public String processForm(  @Validated  ItemForm itemForm, BindingResult result,
        Map model) {
    if (hasDuplicatedName(itemForm) {
        result.reject(DUPLICATE, "Name is already in use");
    }
    if (result.hasErrors()) {           
        model.put("typeList", dao.getItemTypes());
        return "itemmaster";
    }
    ...