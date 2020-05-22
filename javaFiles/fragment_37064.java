@RunWith(PowerMockRunner.class)
@PrepareForTest(MDI.class)
public class FooTest {

   @Test
   public void testCreateA() throws Exception {
      PowerMockito.mockStatic(MDI.class);
      PowerMockito.when(MDI.check(anyString(), anyString(), anyString())).thenReturn("Expected Answer");
      // test createA method
   }
}