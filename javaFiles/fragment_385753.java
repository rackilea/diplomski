import lotus.domino.*;

public class JavaAgent extends AgentBase {

    public void NotesMain() {
      try {

          WsClass stub = new WsClassServiceLocator().getDomino();
          stub.setCredentials("testuser", "password");
          System.out.println(stub.HELLO("world"));

      } catch(Exception e) {
          e.printStackTrace();
       }
   }
}