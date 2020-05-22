class ComplexNumber{
   public ComplexNumber(double re, double im)
   {
       _re = re;
       _im = im;
   }

   private double _re;
   public double getReal(){
      return _re;
   }
   private double _im;
   public double getImaginary(){
       return _im;
   }

   @overrides
   public boolean equals(object other){
       if(other == null)
          return false;
       ComplexNumber n = (ComplexNumber)other;
       return _re.equals(n._re) && _im.equals(n._im);
   }

   @overrides
   public boolean getHashCode(){
       return _re.getHashCode() ^ _im.getHashCode();
   }

   @overrides
   public void toString(){
       return "(" + re.toString() + "," + im.toString() + ")";
   }
}