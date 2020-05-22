class  Report
 {
        // declare instance variables (arrays)
        public String[] departments = null;
        public double[] grossTotals = null;
        public double[] taxTotals = null;


        // constructor
        public Report(){
              this.departments = new String[]{"Accounting", "Sales", "HR", "Administration"} ;
         this.grossTotals = new double[]{0.0, 0.0, 0.0, 0.0} ;
         this.taxTotals = new double[]{0.0, 0.0, 0.0, 0.0} ;
    } // END constructor
 }