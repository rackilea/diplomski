@RunWith(PowerMockRunner.class)
@SuppressStaticInitializationFor("com.my.test.StaticClass")
public class SampleTest {


    @Test
    public void test() {
        StaticClass mockInstance = EasyMock.createNiceMock(StaticClass.class);
        EasyMock.replay(mockInstance);

        System.out.println(mockInstance.toString());
    }

}