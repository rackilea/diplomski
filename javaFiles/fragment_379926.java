public interface IA { 
  void foo(); 
  // void bar(); // Removed method. 
} 

public class B : IA { 
  void IA.foo() {}
  void IA.bar() {} // does not compile
}