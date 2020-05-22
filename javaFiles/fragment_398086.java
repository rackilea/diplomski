@RestController
public class EventController {

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public ResponseEntity post(@RequestBody Event event) {
        System.out.println("Event posted: " + event.toString());
        return ResponseEntity.ok(event);
    }

}