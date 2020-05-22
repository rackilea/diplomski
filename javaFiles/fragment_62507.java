@RequestMapping("/storeTeam")
public String storeTeam(@ModelAttribute("theTeam")Team enteredTeam,BindingResult result){
    teamManager.saveTeam(enteredTeam); //the @ModelAttribute is binding to the model attribute added in the get method

    return "home";
}