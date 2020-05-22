public class PersonaTest {
    private Persona p; // changed to a member

    @Before
    public void setUp() {
        // But p is still initialized here:
        p = new Persona();
        p.setDni(38890422);
        p.setEdad(24);
        p.setNombre("Nicolas");
        p.setSueldo(25000);
    }

    @Test
    public void testGestDni() {
        int resultado = p.getDni(); // Tests can now use p
        int resultadoEsperado = 38890422;

        Assert.assertEquals(resultadoEsperado, resultado);
    }
}