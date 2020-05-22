public interface MyStateless {

     void doSomething();         

 }

 /**
   * Be aware you CAN NOT USE @Local and @Remote at the same time
   */

 @Local
 public interface MyStatelessLocal extends MyStateless {}

 @Remote
 public interface MyStatelessRemote extends MyStateless {}