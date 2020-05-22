@Controller
@RequestMapping("/status")
public class ScannerStatusController {

    @Autowired
    ScannerStatus status;

    /**
     * @return Status object (as json)
     */
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody ScannerStatus doResponse()  {
        return status;
    }

}