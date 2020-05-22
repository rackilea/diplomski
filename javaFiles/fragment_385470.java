public ThingTest // We have a class named Thing we want to test, this is its unit tests
{

   @Test
   public void testIncrement() // Test of the Thing.increment method
   {
      // Set up:
      var thing = new Thing(); // Using part of the Thing class in the set up phase!

      // Exercise:
      thing.increment();

      // Verify:
      assertEquals(1, thing.count());
   }
...