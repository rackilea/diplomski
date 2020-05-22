@RunWith(PowerMockRunner.class)
@PrepareForTest(Titi.class) // stub the calling class Titi, not Toto!
public class TitiTest {
  @Test public void testExecuteTiti() {
    Toto toto = Mockito.spy(new Toto());
    Mockito.doReturn(2).when(toto).executeToto(Mockito.any(Tutu.class));

    PowerMockito.whenNew(Toto.class).withAnyArguments().thenReturn(toto);

    Titi testedObject = new Titi();
    testedObject.executeTiti();
  }
}