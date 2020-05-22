public class MySecurityMgr extends SecurityManager {
   ... 

   @Override
    public void checkExit(int status) {
            throw new RuntimeException(Integer.toString(status));
    }
}