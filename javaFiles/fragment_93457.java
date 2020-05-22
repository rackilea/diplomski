import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

private HashMap<String, Object> createMessageDetails(String project_key, String repository) {
  HashMap<String, Object> details = new HashMap<>();
  details.put("project_key", project_key);
  details.put("repository", repository);
  return details;
}

public class FedmsgEventListenerTest {
  @Test
  public void testOpened() {
    // when
    PullRequestOpenedEvent event = mock(PullRequestOpenedEvent.class);
    when(event.someMethodForPrExtracterYouHaventShownMe()).thenReturn(createMessageDetails("myKey", "myRepo"));

    // then
    FedmsgEventListener listener = new FedmsgEventListener();
    listener.opened(event);

    // verify
    assertThat(event.getTopic(), containsString(".pullrequest.opened"));
    verify(event).someMethodForPrExtracterYouHaventShownMe();
  }
}