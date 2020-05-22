String z = "variable";

  class MyInner {
        public void seeOuter(){
            System.out.println("Outer x is "+x);
            System.out.println("Local variable z is "+z);
        }
    }
  MyInner my=new MyInner();

  z = "another value";

  my.seeOuter();