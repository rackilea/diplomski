@Controller
public class ViewAllData {

    private final DBQuery dbQuery;

    @Autowired
    public ViewAllData(DBQuery dbQuery){
        this.dbQuery = dbQuery;
    }

    @RequestMapping("/viewAllData")
    public ModelAndView viewData() {
        String dataTable;
        List<Passport> passports = dbQuery.getAllDataPassports();
        // List to whatever it needs to be
        return new ModelAndView("viewAllData", "message", dataTable);
    }
}