public class C {
  private Hashtable agents;

  private synchronized Hashtable getAgents() {
    if( this.agents == null ) {
      this.agents = createAgents();
    }

    return this.agents;
  }

  public iterate() {
    Iterator i = getAgentKeyIterator();

    while( i.hasNext() ) {
      // Code that uses i.next() ...
    }
  }

  protected Hashtable createAgents() {
    return new Hashtable();
  }

  private Iterator getAgentKeyIterator() {
    return getAgentKeys().iterator();
  }

  private KeySet getAgentKeys() {
    return getAgents().keySet();
  }
}