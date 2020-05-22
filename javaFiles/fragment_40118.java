@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ReferenceTablesControllerTests {

    @LocalServerPort
    private int port;

    @Test
    public void getXxxx() throws Exception {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "tokenxxx");
        ResponseEntity<YourResponseObj> entity = new TestRestTemplate().exchange(
                "http://localhost:" + port + "/youruri", HttpMethod.GET, new HttpEntity<Object>(headers),
                YourResponseObj.class);
        Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
        Assert.assertEquals("foo", entity.getBody().getFoo());
    }

}