@RequestMapping(path="/item", method=RequestMethod.POST)
public void addNewItem(@ModelAttribute Item item, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        bindingResult.getAllErrors().forEach(e -> System.out.println(e.toString()));
        // Handle error
    }
    Item newItem = new Item();
    newItem.setItemDesc(item.getItemDesc());
}