@Controller
public class RestController {

    @RequestMapping(value = { "/restCallBack" }, method = RequestMethod.GET)
    @ResponseBody
    public String performCallBack(@RequestParam("devideId") String devideId, 
            @RequestParam("time") String time,
            @RequestParam("duplicate") String duplicate,
            /* more request params... */ {

        RestCallCallBack restCallCallBack = new RestCallCallBack();
        restCallCallBack.setDevideId(devideId);
        restCallCallBack.setTime(time);
        restCallCallBack.setDuplicate(duplicate);
        // set more params...

        // perform validation
        return "computerList";
    }
}