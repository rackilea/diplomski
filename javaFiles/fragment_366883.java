@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk=21)
public class RestaurantModelTest {

    @Test
    public void hire() throws Exception {
        RestaurantModel restaurantModel = new RestaurantModel();
        assertEquals(0, restaurantModel.staff);
        restaurantModel.hire(1);
        assertEquals(1, restaurantModel.staff);
    }
}