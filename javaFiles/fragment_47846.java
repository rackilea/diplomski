@RestController
public class BeneficiarioController {

@Autowired
BeneficiarioRepository beneficiarioRepository;

@Autowired
private final BeneficiarioService beneficiarioService;

@Inject
public BeneficiarioController(final BeneficiarioService beneficiarioService) {
    this.beneficiarioService = beneficiarioService;
}

@RequestMapping(value = "/beneficiario/{id}", method = RequestMethod.GET)
@ResponseBody
public Object queryBeneficiario(@PathVariable("id") Long id) {
    Beneficiario beneficiario = beneficiarioService.getBeneficiario(id);
    return beneficiario;
}