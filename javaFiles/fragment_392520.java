@RunWith(MockitoJUnitRunner.class)
public class PlaneLocatorTest {
    @Mock CompanyProvider mockedCompanyProvider;
    @Mock PlaneProvider mockedPlaneProvider;
    @Mock LocationUtil locationUtil;
    @InjectMocks SatelitePlaneLocator testedPlaneLocator;

    @Test public void should_use_LocationUtil_to_get_distance_between_plane_location() {
        // given
        given(companyProvider.get(anyString())).willReturn(new Company());
        given(planeProvider.get(anyString()))
                .willReturn(Plane.builder().withLocation(new Location("A")))
                .willReturn(Plane.builder().withLocation(new Location("B")));

        // when
        testedPlaneLocator.getDistanceBetweenPlanes("AF", "1251", "721");

        // then
        verify(locationUtil).distance(isA(Location.class), isA(Location.class));
    }

    // other more specific test on PlaneLocator
}