@RequestMapping(value="/deleteTeam", method=RequestMethod.POST)
public @ResponseBody String editDeleteRecodes(@RequestParam("teamID") String teamID) {     
    Teams teams = new Teams();
    teams.setTeamID(newTeams.getTeamID());

    String result;
    try {
        teamService.delete(teams);
        result = "{deleted: true}";
    } catch (DataIntegrityViolationException ex){
        result = "{deleted: false}";
    }

    return result;        
}