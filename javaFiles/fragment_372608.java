@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MainConfig.class})
public class AbstractCSVFileProcessOpTest {

    @Autowired
    FileSource fileSource;

    @Autowired
    ReadFileOp readFileOp;

    @PostConstruct
    public void init() {
        // do your task here
    }
}