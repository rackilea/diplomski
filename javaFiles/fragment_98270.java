public interface CountObserver {

 public void updateCount(String className);
 public int getCount(String className);
}

public class CentralObserver implements CountObserver {

 private int aCount;
 private int bCount;

 public void updateCount(String className) {

 //There's probably a better way to do this than using
 //all these if-elses, but you'll get the idea.

  if (className.equals("AclassName")) {
   aCount++;
  }
  else if (className.equals("BclassName")) {
   bCount++;
  }
 }

 public int getCount(String className) {

  if (className.equals("AclassName")) {
   return aCount;
  }
  else if (className.equals("BclassName")) {
   return bCount;
  }
}

class A implements Listener {

 CountObserver countObserver;

 public void registerObserver (CountObserver countObserver) {

  this.countObserver = countObserver;
 }

 public void onEvent(char e) {

  if(e == 'a') {

   countObserver.updateCount (this.getClass.getName);
  }
 }

}

//Same thing for B or any other class implementing Listener. Your Listener interface should, of 

//course, have a method signature for the registerObserver method which all the listener classes 

//will implement.

class Run {

 private A a;
 private B b; 
 private CountObserver centralObserver;

 public runProgram () {

  centralObserver = new CentralObserver();
  a.registerObserver(centralObserver);
  b.registerObserver(centralObserver);

 //run OnEvent method for A a couple of times, then for B

 }

 public int getAcount () {

 return centralObserver.getCount(a.getClass.getName());
 }

 public int getBcount () {

 return centralObserver.getCount(b.getClass.getName());
 }
} 
 //To get the sum of all the counts just call getAcount + getBcount. Of course, you can always  add more listeners and more getXCount methods