public class GodClass
{
    private static final GodClass INSTANCE = new GodClass();

    private GodClass() {}

    public static GodClass getInstance()
    {
        return INSTANCE;
    }

    public String sayHi()
    {
        return "Hi!";
    }
}

public class Testee
{
    private GodClass gc;
    public Testee() {
        gc = GodClass.getInstance();
    }

    public String saySomething()
    {
        return gc.sayHi();
    }
}

@RunWith(PowerMockRunner.class)
@PrepareForTest(GodClass.class)
public class GodClassTester
{
    @Test
    public void testThis()
    {
        PowerMockito.mockStatic(GodClass.class);
        GodClass mockGod = PowerMockito.mock(GodClass.class);
        PowerMockito.when(mockGod.sayHi()).thenReturn("Hi!");
        PowerMockito.when(GodClass.getInstance()).thenReturn(mockGod);

        Testee testee = new Testee();
        assertEquals("Hi!", testee.saySomething());

    }
}