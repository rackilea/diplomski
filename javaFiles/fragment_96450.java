@Controller
public class SampleRaptorController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent( @ModelAttribute("SpringWeb") Student student,
                    Model model){

        // Build URL
        StringBuilder url = new StringBuilder().
                        append("http://localhost:8080/service/newservice/v1/get").
                        append("?PP.USERID=" + student.getUserId).
                        append("&debugflag=" + student.isDebugFlag);// so on

        // Call service
        String result = restTemplate.getForObject(url.toString(), String.class);
        model.addAttribute("result", result);

        return "result";
    }

}