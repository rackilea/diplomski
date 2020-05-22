@RestController
@RequestMapping("/appraisal")
public class AppraisalController {

  @Autowired
  AppraisalServiceImpl appraisalService;

  @GetMapping(value = "/get")
  public Flux<AppraisalCombine> uploadSimple() {
    return appraisalService.combineTwo();
  }
}