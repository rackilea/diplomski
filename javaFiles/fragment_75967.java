@Controller
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value="/create", method=POST)
    public String createRoom() {
        roomService.createRoom(/* Parameters for room creation */);
        return "redirect:/somelocation";
    }
}