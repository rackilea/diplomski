public class CapabilityToken {
  public String get(String applicationSid) {
    TwilioCapability capability = new TwilioCapability(ACCOUNT_SID, AUTH_TOKEN);
    capability.allowClientOutgoing(applicationSid);
    try {
      String token = capability.generateToken();
      // logging happens here
      return token;
    } catch (DomainException e) {
      e.printStackTrace();
    }
  }
}