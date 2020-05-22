package package2;
import package1.*;

public class Test {
  void test(){
    // this line won't compile - FrameSize class is unknown
    FrameSize x = Video.frameSize; 

    // but this line compiles fine - Object class is public
    Object y = Video.frameSize; 
   }
}