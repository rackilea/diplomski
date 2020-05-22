long v = 0;
      byte q = -2; // unsigned value of 254
      v = v + q;
      System.out.println(v); // prints -2 which is not what you want.
      v = 0;
      v = v + (q & 0xFF); // mask off sign extension from q.
      System.out.println(v); // prints 254 which is correct.