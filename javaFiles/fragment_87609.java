static int main( String[] args ) {
// setup game world

final RandomStrategy r = "random".equals(args[0]) 
  ? new PlatformRandom() : new  NotSoRandom( Integer.intValue(args[0]) ) ;
// notice the simlarity to the code you originally posted;
// we factored out how to achieve "randomness" as a Strategy.

// now we will use our Strategy to setup our Factory;

final ModeFactory f = "test".equals(args[1])
  ? new TestFactory(r) : new MainFactory(r);
// also similar to your code
// we've just added an extra level of indirection: 
// instead of creating a Mode, we've created an object that can create Modes
//  of the right derived type, on demand.

// call something that uses our factory
functionThatRunsameAndNeedstoProduceModesWhenevertNeedsTo( f ); 

}