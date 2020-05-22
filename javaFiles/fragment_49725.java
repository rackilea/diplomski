interface StateChanger(){ 
    public void call( State state );
 }

 class A {

   protected State state

   public State getState(){ return state; }

   public void setState( StateChanger stateChanger ){
     stateChanger.call( state );
   }
 }