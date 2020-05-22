@Component
@Path("/doctor")
public class DoctorController {

    @Autowired
    DoctorCrudRepo doctorCrudRepo;

    @Path("/list")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(Views.Doctors.class)
    public JsonResponse<List<Doctor>> list() {
        return JsonResponse.success(OpsidUtils.iterableToList(doctorCrudRepo.findAll()));
    }

}