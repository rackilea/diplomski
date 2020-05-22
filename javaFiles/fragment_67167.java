@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes = Application.class)
@ContextConfiguration(classes = Application.class, initializers = DemoApplicationContextInitializer.class)
public class MyTest {
...
}