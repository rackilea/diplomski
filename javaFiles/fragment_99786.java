@PrepareForTest(ArrayListMultimap.class)
public class PowerMockitoTest {

  @Rule // used instead @RunWith(PowerMockRunner.class) in newer version of JUnit
  public PowerMockRule rule = new PowerMockRule();

  @Test
  public void testPowerMockitoVsGuava() {
    final ArrayListMultimap<String, String> mock =
        PowerMockito.mock(ArrayListMultimap.class);
    PowerMockito.when(mock.put("foo", "bar")).thenReturn(true);
    Assert.assertTrue(mock.put("foo", "bar")); // SOError!
  }

}