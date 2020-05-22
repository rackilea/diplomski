@RestController
class HelloController {

    private final ScheduledJob scheduledJob;

    // constructor

    @GetMapping("/launch")
    void toggle() {
        scheduledJob.toggle();
    }

}