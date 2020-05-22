@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@WithUserDetails(value = "email@address.com")
@TestExecutionListeners(mergeMode = MergeMode.MERGE_WITH_DEFAULTS, 
                        value=MyMockUserTestExecutionListener.class) 
public abstract class IntegrationTests {
 ...
}