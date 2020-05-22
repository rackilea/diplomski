import lotus.domino.*;

public class JavaAgent extends AgentBase {

  public void NotesMain() {

    try {
      Session session = getSession();
      AgentContext agentContext = session.getAgentContext();

      // (Your code goes here) 

      // Create a hierarchical name
      Name nam = session.createName(
        "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US");

      // Returns:
      // John B Goode
      // John B Goode/Sales/East/Acme/US
      // CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US
      System.out.println(nam.getCommon());
      System.out.println(nam.getAbbreviated());
      System.out.println(nam.getCanonical());

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}