@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@Transactional
@Rollback
public abstract class BaseIntegrationTest {
  @MockBean
  ExternalService externalService;
}