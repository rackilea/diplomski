@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class SampleTest {

    @Configuration
    static class ContextConfiguration {
        @Bean
        public AmazonS3 gets3(){
            System.out.println("Providing mocked s3...");
            //TODO: Provide when/then statements, etc
            return Mockito.mock(AmazonS3.class);
        }
    }

    @Test
    public void testSomething(){
      //TODO: Test something that utilizes S3Client
    }
}