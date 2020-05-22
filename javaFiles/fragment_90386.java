public class MigrationRuleController {
    @Inject
    private MigrationRuleService migrationRuleService;

    @RequestMapping(method = RequestMethod.POST)
    public String migrationRuleUpload(@RequestParam("file") MultipartFile file) {
        return migrationRuleService.migrationRuleUpload(file);
    }
}