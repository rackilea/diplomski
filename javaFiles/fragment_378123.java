import lotus.domino.*;

public class ExampleAgent1 extends AgentBase {

    public void NotesMain(){
        try{
            Session session = getSession();
            AgentContext context = session.getAgentContext();
            Document doc = agentContext.getDocumentContext();
            System.out.println(doc.getItemValueString("Request_Content"));
        }
        catch(Exception exc){
            System.out.println("Unknown error occured");
        }
    }

}