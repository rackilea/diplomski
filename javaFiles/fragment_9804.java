@RequestMapping({"player/{playerId}/show"})
    public String getPlayerById(Model model, @PathVariable String playerId) {

        model.addAttribute("player", playerService.getPlayerById(Long.valueOf(playerId)));
        model.addAttribute("ageCalculator", new AgeCalculator());
        return "event/player/showPlayerById";
    }