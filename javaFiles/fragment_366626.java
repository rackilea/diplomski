@RestController
public class ControllerRest {

    @Autowired
    private MessagesRepository msgRepo;

    RestTemplate restTemplate;

    @GetMapping({ "/StatusData" })
    public List<Messages> index() {
        return this.msgRepo.findAll();
    }

    @PostMapping(path = {"/postdata"})
    public ResponseEntity<Messages> createBody(@RequestBody Map<String, String> body) {
        Messages  msgDao = new Messages();
        msgDao.setTemplate((String) body.get("template"));
        msgDao.setParameters((String) body.get("parameters"));
        msgDao.setHsm((String) body.get("hsm"));
        msgDao.setTo((String) body.get("to"));

        return new ResponseEntity<Messages>(this.msgRepo.save(this.HttpStatus.OK);
    }
}