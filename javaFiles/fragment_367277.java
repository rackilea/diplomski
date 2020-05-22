@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = ["server.port=4333"])
class GreetingController2Test {
    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun `should return uri`() {
        val responseEntity = restTemplate.getForEntity("/greeting", Greeting::class.java)
        val greeting = responseEntity.body!!
        assertEquals("http://localhost:4333/greeting", greeting.uri)
    }

    @Test
    fun `should return uri composed from forwarded-??? headers`() {
        val headers = HttpHeaders()
        headers["X-Forwarded-Host"] = "external-uri.com"
        headers["X-Forwarded-Proto"] = "https"
        headers["X-Forwarded-Prefix"] = "/prefix"

        val httpEntity = HttpEntity(null, headers)
        val responseEntity = restTemplate.exchange("/greeting", HttpMethod.GET, httpEntity, Greeting::class.java)
        val greeting = responseEntity.body!!
        assertEquals("https://external-uri.com/prefix/greeting", greeting.uri)
    }
}