@RequestMapping(value = "/admin/save/developer", method = RequestMethod.POST)
public String createAgentAccount(Model model, String admin_id, String confirmPassword, String action, @ModelAttribute("agent") Developer developer, BindingResult result) {
    return createAgentAccount(model, admin_id, confirmPassword, action, developer, result);
}

@RequestMapping(value = "/admin/save/support", method = RequestMethod.POST)
public String createAgentAccount(Model model, String admin_id, String confirmPassword, String action, @ModelAttribute("agent") Support support, BindingResult result) {
    return createAgentAccount(model, admin_id, confirmPassword, action, support, result);
}

private String createAccount(Model model, String admin_id, String confirmPassword, String action, Agent agent, BindingResult result) {

    Agent admin = iAdmin.profile(Integer.parseInt(admin_id));

    agent.setConfirmPassword(confirmPassword);

    agentValidator.validate(agent, result);

    if (result.hasErrors()) {

        model.addAttribute("action", action);

        return "formAgents";
    }

    if (action.equals("create")) {

        iAdmin.createAgent(admin, agent);

    } else {

        iAdmin.updateAgent(admin, agent);

    }

    return "redirect:/admin/show/agents";
}