@RestController
     @EnableSwagger2
        @Import(BeanValidatorPluginsConfiguration.class)
    @RequestMapping("/v2/persons/")
    @Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Persons.")
    public class PersonController {

        private PersonService personService;

        @RequestMapping(method = RequestMethod.GET, produces = "application/json")
        @ApiOperation("Returns list of all Persons in the system.")
        public List getAllPersons() {
            return personService.getAllPersons();
        }