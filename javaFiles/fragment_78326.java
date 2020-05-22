@RequestMapping(value="/ajouterUniversite",method=RequestMethod.POST)
    public String ajoutUniver(Model model,@RequestParam(required = false) String nom,@RequestParam(required = false) String region,@RequestParam(required = false) String scoreMath, @RequestParam(required = false) String scoreScience, @RequestParam(required = false) String scoreEco, @RequestParam(required = false) String scoreInfo,@RequestParam(required = false) String scoreLettre )
    {

    model.addAttribute("ok","cv");
    Universite u=new Universite(nom,region);
    or.ajouterUniversite(nom, region, Double.parseDouble(scoreMath), Double.parseDouble(scoreScience), Double.parseDouble(scoreInfo), Double.parseDouble(scoreLettre), Double.parseDouble(scoreEco));
    return "admin";
}