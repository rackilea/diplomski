public class C {
  private Hashtable agents;

  private synchronized Hashtable getAgents() {
    if( this.agents == null ) {
      this.agents = new Hashtable();
    }

    return this.agents;
  }

  public iterate() {
    Hashtable agents = getAgents();

    for (Iterator iter = agents.keySet().iterator(); iter.hasNext();) {
      // Code goes here
    }
  }
}