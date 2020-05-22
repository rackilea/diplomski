@Service
    public class BeneficiarioServiceImpl implements BeneficiarioService {

        @Autowired
        BeneficiarioRepository beneficiarioRepository;

        @Override
        public Beneficiario getBeneficiario(Long id) {
            Beneficiario beneficiario = beneficiarioRepository.findById(id);
            return beneficiario;
        }
    }