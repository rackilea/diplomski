import lotus.domino.*;
public class JavaAgent extends AgentBase {
  public void NotesMain() {
    try {
      Session session = getSession();
      AgentContext agentContext = session.getAgentContext();
      // (Your code goes here)
      Database db = agentContext.getCurrentDatabase();
      DocumentCollection dc = db.getAllDocuments();
      Document tmpdoc;
      Document doc = dc.getFirstDocument();
      while (doc != null) {
        System.out.println(doc.getItemValueString("Subject"));
        tmpdoc = dc.getNextDocument();
        doc.recycle();
        doc = tmpdoc;
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}