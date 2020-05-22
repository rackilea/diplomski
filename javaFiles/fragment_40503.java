@RepositoryRestController
public class RuleSetCustomController {

    private final RuleSetRespositry repository;

    @Autowired
    public RuleSetCustomController(RuleSetRespositry repo) { 
        this.repository = repo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ruleSets/{ruleSetId}/ruleConfigurations/search/findByActive") 
    public @ResponseBody ResponseEntity<?> getProducers(@PathVariable Long ruleSetId, @RequestParam Boolean active) {
        RuleSet ruleSet = repository.findOne(ruleSetId);

        if(ruleSet == null) return ResponseEntity.notFound().build();

        List<RuleConfiguration> resp = ruleSet.getRuleConfigurations().stream().filter(ruleConf -> ruleConf.isActive() == active).collect(Collectors.toList());

        Resources<RuleConfiguration> resources = new Resources<RuleConfiguration>(resp); 

        return ResponseEntity.ok(resources); 
    }

}