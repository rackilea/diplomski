public void yourMethod(int size)
    {
       if(size > 14)
         throw new IllegalArgumentException("max size is 14, size too big: " + size);

       // actual code
    }