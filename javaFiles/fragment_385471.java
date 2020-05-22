@Test
   public void testIncrement()
   {
      var thing = new Thing();
      assert thing.count() == 0;

      thing.increment();

      // Verify:
      assertEquals(1, thing.count());
   }
...