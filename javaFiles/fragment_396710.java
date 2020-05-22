/**
   * Global JNDI address will be earName/MyStatelessImpl/local and earName/MyStatelessImpl/remote
   */
 @Stateless
 @Name("myStateless")
 public class MyStatelessImpl implements MyStatelessLocal, MyStatelessRemote {

     public void doSomething() {

     }

 }