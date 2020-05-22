@RequestMapping(method = RequestMethod.GET)
public String showNames(Model model) {
    ...
    model.addObject ....
    return "names";
}

@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
public String showNameDetails(@PathVariable String name, Model model) {
    ...
    model.addObject ...
    return "name";
}

@RequestMapping(value = "/name/{name}/{item}", method = RequestMethod.GET)
public String showItemsOfName(@PathVariable String name,
        @PathVariable String item, Model model) {
    ...
    model.addObject ....
    return "item";
}