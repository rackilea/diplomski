@SpringBootTest
@RunWith(SpringRunner.class)
public class UtilityTests {

    @Autowired
    private ReviewMapper reviewMapper;

    @Test
    public void reviewMapperIsNotNull(){
        assertThat(reviewMapper, notNullValue());
    }

    @Test
    public void testMapper(){
        RideReviewDTO reviewDTO = new RideReviewDTO();
        reviewDTO.setDescription("Test RideReviewDTO description");
        reviewDTO.setUserRating(5.0F);
        RideReview rideReview = reviewMapper.toEntity(reviewDTO);
        assertThat(rideReview.getUserRating(), equalTo(5.0F));
    }

}