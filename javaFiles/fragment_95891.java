@RequestMapping(value="adduser")
public String addUserForm(Model model)
{
    logger.info("===addUserForm ");
    model.addAttribute("user", new User());
    return "AddUserForm";
}