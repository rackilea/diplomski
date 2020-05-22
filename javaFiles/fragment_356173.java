@WebAppConfiguration
@ContextConfiguration(locations = {
        "......"
        )
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@PowerMockIgnore("javax.management.*") // to specify that all classes under the specified package be loaded by the system class loader
@PrepareForTest({Static.class})
public void ControllerTest {
    public void testMockStatic() {
        PowerMockito.mockStatic(Static.class);
        ......
    }
}