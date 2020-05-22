// in the constructor
   this.range = maxValue - minValue + 1;
   this.value = -minValue;

   // in the adder.
   public void add(int num) {
       value = (value + num) % range;
       if(value < 0) value += range;
       // or
       value = ((value + num) % range + range) % range;
   }


   // add a getter for value.
   public int getValue() { return value + minValue; };