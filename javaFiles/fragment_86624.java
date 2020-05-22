public class FooPageTest extends AbstractServiceTest{

    @Autobuild
    @Inject
    private FooPage fooPage;

    @Test
    public void setupRender(){
        fooPage.setupRender();
    }

}