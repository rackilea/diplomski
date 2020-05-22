class A {

   protected State state

   public State getState(){ return state; }
 }

 class B extends A {

   public void setState( State s ){ this.state = s }

 }