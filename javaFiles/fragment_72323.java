@PostMapping("/get_all_items/add_item_page/add_item")
public String addItem(@RequestParam(value = "description")
                          final String description, Principal principal) {

    MySpringUser mySpringUser = (MySpringUser)principal;

    final Item item = new Item();

    item.setDescription(description);

    item.setAuthorId(mySpringUser.getUser().getId());

    service.add(item);

    return "redirect:get_all_items";
}