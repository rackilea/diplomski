@Autowired
    TestRepository testRepo;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    @ResponseBody
    List<Mission> getall() {
        List<Mission> missions = testRepo.findAllMissions("Test");
        return missions;
    }