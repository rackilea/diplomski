@RequestMapping(value="/showteams", method=RequestMethod.GET)
public String teams()
{
   Set<Team> teams = (Set<Team>) teamRepository.findAll();
   model.addAttribute("teams", teams);
   return "teams";//here your name of your view (html)
}