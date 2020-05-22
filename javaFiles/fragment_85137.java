@RequestMapping(value = "create", method = RequestMethod.GET)
 public String create_form(Model model, @ModelAttribute("channelNode") ChannelNode channelNode,
    BindingResult result) {

    return CHANNELNODE_ADD_VIEW;
 }