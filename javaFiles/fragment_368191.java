public class AnimalFactoryTest {
    @Test
    public void testCreateDog() throws Exception {
        AnimalFactory mockFactory = mock(AnimalFactory.class);
        when(mockFactory.createAnimal(anyString())).thenCallRealMethod();

        mockFactory.createAnimal("canine");
        verify(mockFactory).createDog();
    }

    @Test
    public void testCreateCat() throws Exception {
        AnimalFactory mockFactory = mock(AnimalFactory.class);
        when(mockFactory.createAnimal(anyString())).thenCallRealMethod();

        mockFactory.createAnimal("cat");
        verify(mockFactory).createCat();
    }
}