@Service
@SpringApplicationConfiguration(SpringConfig.class)
public class AutowiredClazz {
    @Autowired
    @Qualifier("the name of the desired bean")
    private BaseInterface baseInterface;

    private AutowiredClazz(BaseInterface baseInterface){
        this.baseInterface = baseInterface;
    }
}