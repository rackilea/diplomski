package com.example.bugs;

public class WeirdInnerClassJavaWarning {
    private static class InnerClass {
        protected InnerClass() {}  // This constructor makes the warning go away
        public void doSomething() {}
    }

    final private InnerClass anInstance;
    {
        this.anInstance = new InnerClass(); 
        this.anInstance.doSomething();
    }
}