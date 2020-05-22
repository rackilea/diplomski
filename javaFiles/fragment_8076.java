public class ReportBuilderResourceTest extends JerseyTest {

 @Override
 protected Application configure() {
     return new ResourceConfig(ReportBuilderResource.class);
 }
...
}