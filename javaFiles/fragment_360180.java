@RestController
@RequestMapping("/trainRun")
public class TrainRunController {

    @RequestMapping(value = "/{year}/{month}/{day}/{trainNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public TrainRun getTrainRun(@PathVariable Integer year, @PathVariable Integer month, @PathVariable Integer day,
                                @PathVariable String trainNumber) { ... }
}