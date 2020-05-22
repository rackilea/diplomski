import com.intersys.globals.*;

class FetchNodes {
  public static void main(String[] args) {
    Connection myConn = ConnectionContext.getConnection();
    try {
      myConn.connect("User", "_SYSTEM", "SYS");
      NodeReference nodeRef = myConn.createNodeReference("myGlobal");
      // Read both existing nodes
      System.out.println("Value of ^myGlobal is " + nodeRef.getString());
      System.out.println("Value of ^myGlobal(\"sub1\") is " + nodeRef.getString("sub1"));
      nodeRef.kill();   // delete entire array
      nodeRef.close();
      myConn.close();
    }
    catch (GlobalsException e) { System.out.println(e.getMessage()); }
  } // end Main()
} // end class FetchNodes