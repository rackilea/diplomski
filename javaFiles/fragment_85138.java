@RequestMapping(value = "create/{id}", method = RequestMethod.GET)
public String create_form(@PathVariable(value = "id") Long id,Model model, @ModelAttribute("channelNode") ChannelNode channelNode,
    BindingResult result) {

    return CHANNELNODE_ADD_VIEW;
}