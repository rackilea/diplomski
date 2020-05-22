@PostMapping("/addPeopleToTeams/{teamId}/{personId}")
    @ResponseBody
    public String addPeopleToTeam(@PathVariable Long teamId, @PathVariable Long personId){

        TeamsAndPersonsId teamsAndPersonsId = new TeamsAndPersonsId(teamId, personId);
        // etc...