@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/integration-test-context.xml")
public abstract class AbstractElasticsearchIntegrationTest {

    @Autowired
    private Client elasticsearchClient;

    // Your rests go here...

}