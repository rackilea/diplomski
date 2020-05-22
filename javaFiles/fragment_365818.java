@RunWith(MockitoJUnitRunner.class)
public class FilterDataControllerTest {
    @Mock
    FilterDataProvider filterDataProvider;
    @InjectMocks
    FilterDataController controller;

    @Test(expected = ValueNotAllowedException.class)
    public void testGetPossibleFilterDataIncorrectDates() {
        controller.getPossibleFilterData(new Date(1L), new Date(0L));
    }

    @Test
    public void testGetPossibleFilterDataCorrectDates() {
        // Make the mock returns a list of fake possibilities
        Mockito.when(
            filterDataProvider.getPossibleCountries(
                Mockito.anyObject(), Mockito.anyObject()
            )
        ).thenReturn(Arrays.asList("foo", "bar"));
        ResponseEntity<Object> response = controller.getPossibleFilterData(
            new Date(0L), new Date(1L)
        );
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        // Make sure that 
        // filterDataProvider.getPossibleCountries(new Date(0L), new Date(1L))
        // has been called as expected
        Mockito.verify(filterDataProvider).getPossibleCountries(
            new Date(0L), new Date(1L)
        );
        // Test response.getBody() here
    }

    @Test
    public void testGetPossibleFilterDataEqualDates() {
        // Make the mock returns a list of fake possibilities
        Mockito.when(
            filterDataProvider.getPossibleCountries(
                Mockito.anyObject(), Mockito.anyObject()
            )
        ).thenReturn(Arrays.asList("foo", "bar"));
        // Call the controller with the same dates
        ResponseEntity<Object> response = controller.getPossibleFilterData(
            new Date(1L), new Date(1L)
        );
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Mockito.verify(filterDataProvider).getPossibleCountries(
            new Date(1L), new Date(TimeUnit.DAYS.toMillis(1))
        );
        // Test response.getBody() here
    }
}