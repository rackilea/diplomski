public class DossierReportItemXlsImporterImpl implements DossierRerportItemXlsImporer {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DossierReportService dossierReportService;
    @Autowired
    private DossierReportItemService dossierReportItemService;
    @Autowired
    private NandoCodeService nandoCodeService;

    public DossierReportItemXlsImporterImpl(final ApplicationContext contex){
        contex.getAutowireCapableBeanFactory().autowireBean(this);
    }

    //...
}


 public class DossierRerportItemXlsImporerTest extends AuditorServiceTest{

        @Autowired
        private ApplicationContext context;
        @Autowired
        private DossierReportService dossierReportService;
        @Autowired
        private DossierReportItemService dossierReportItemService;

        @Test
        public void testXlsImport(){
            DossierRerportItemXlsImporer importer = new DossierReportItemXlsImporterImpl(context);
            importer.processImport(createDossierReport(), loadFile());
            // ...
        }
      // ...
    }