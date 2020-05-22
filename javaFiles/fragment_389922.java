@RunWith(PowerMockRunner.class)
@PrepareForTest(MyClass.class)
public class TestMyClass {

    @Test
    public void test() throws Exception {
        //Arrange

        // mock MqttClient
        MqttClient field = mock(MqttClient.class);
        // setup the "new MqttClient(null, null);"
        PowerMockito.whenNew(MqttClient.class).withArguments(isNull(), isNull()).thenReturn(field);

        MyClass subject = new MyClass();

        //Act
        subject.test();

        //Assert
        PowerMockito.verifyNew(MqttClient.class).withArguments(isNull(), isNull());
        verify(field).connect();
    }
}