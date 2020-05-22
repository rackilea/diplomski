// @RestController = @Controller + @ResponseBody
  @RestController
    public class BackupController {  

        @Autowired
        private BackupService backupService;

        // you don't need @ResponseBody as you use @RestController
        @RequestMapping("/backup")
        public List<FileInfo> backupFiles() {
            return backupService.listBackupFiles()
        }
    }