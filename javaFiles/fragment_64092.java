class SalaryTrigger {

      private int eno;

      public SalaryTrigger(int enum) {

      eno = enum;

      }

     public void check_sal_raise(float old_sal,float new_sal)
     {
        if (((new_sal - old_sal)/old_sal) > .10)
        {
           // raise too high  do something here
           System.out.println("Raise too high for employee " + eno);
        }
     }
   }