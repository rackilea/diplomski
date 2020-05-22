@Autowired
private ValFuncsAuth valFuncsAuth;

@RequestMapping(value = "/create/{tenantid}/{jobid}", method = RequestMethod.POST, produces = "application/json")
public ResponseEntity<Void> createJob (
        @PathVariable BigDecimal tenantid,
        @PathVariable BigDecimal jobid,
        @RequestBody WorkJobChargesParamIOPOJO input) throws Exception {