@Controller
public class SampleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private DtoMapper mapper;

    @PostMapping("/testDto")
    @ResponseBody
    @Transactional
    public BikeDto testDto(@RequestBody VehicleDto vehicleDto) {

        if (vehicleDto instanceof BikeDto)
            vehicleService.saveBike(mapper.toBikeEntity((BikeDto) vehicleDto));

        return mapper.toBikeDto(vehicleService.getBike(vehicleDto.getId()));
    }
}