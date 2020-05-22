class UnderTest {
   SomeLogger logger ... coming into the class via dependency injection

   void foo() {
      try { ... whatever  
      } catch(WhateverException w) {
        logger.error(w....