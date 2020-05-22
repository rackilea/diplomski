@Service
public class AlerteServiceImpl implements AlerteService {

    @Autowired
    private GenericDao<AlerteAcheteur, Long> alerteAcheteurDao;

    @Autowired
    private GenericDao<AlerteVendeur, Long> alerteVendeurDao;

    ...
}