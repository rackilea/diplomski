@RunWith(PowerMockRunner.class)
@PrepareForTest(ExampleWithEvilParent.class)
public class ExampleWithEvilParentTest {

        @Test
        public void testSuppressConstructorOfEvilParent() throws Exception {
                suppress(constructor(EvilParent.class));
                final String message = "myMessage";
                ExampleWithEvilParent tested = new ExampleWithEvilParent(message);
                assertEquals(message, tested.getMessage());
        }
}