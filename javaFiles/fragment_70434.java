@RestController
@RequestMapping("/tdee")
public class Tdee{

    @Autowired 
    @Qualifier("katchTdeeServiceImpl")
    private TdeeService katchTdeeServce;

    @Autowired 
    @Qualifier("harrisTdeeServiceImpl")
    private TdeeService harrisTdeeService;


    @PostMapping
    public getTdee(FooRequest request){

        if(request.isKatch()){
            katchTdeeServce.getTdee();
        }else if(requst.isHarris()){
            harrisTdeeService.getTdee();
        }

    }
}