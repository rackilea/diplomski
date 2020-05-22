@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {
    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    Executor threadPoolTaskExecutor;

    @Test
    public void test() throws InterruptedException {
        MyThread myThread = applicationContext.getBean(MyThread.class);
        if (threadPoolTaskExecutor != null) {
            threadPoolTaskExecutor.execute(myThread);
            threadPoolTaskExecutor.execute(myThread);
            threadPoolTaskExecutor.execute(myThread);
            Thread.sleep(30000);// 10000 + 10000 + 10000 ^^ for each thread
        }
    }
}