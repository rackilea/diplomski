@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CentroDeCustoServiceImpl.class})
public class CentroDeCustoServiceImplTeste {

    @Autowired
    private CentroDeCustoService centroDeCustoService;