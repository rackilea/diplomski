public class XMLPolledConfigurationSource implements PolledConfigurationSource {

@SuppressWarnings("static-access")
@Override
public PollResult poll(boolean inital, Object checkPoint) throws Exception {
    PollResult pollResult = null;
    Map<String, Object> map = new HashMap<>();
    // Code to read content from the resource
    return pollResult.createFull(map);
  }
}