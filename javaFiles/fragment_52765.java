public static void printResults(String[] name, double[] radius, double[] mass, double gravity[]){

    DecimalFormat decimalFormat=new DecimalFormat("#0.00");

      if(name!=null && radius!=null 
              && mass!=null && gravity!=null){

          if(name.length==radius.length 
                  && radius.length==mass.length 
                  && mass.length==gravity.length){

            for(int i=0;i<name.length;i++){

                System.out.println("Name="+name[i]);
                System.out.println("Radius="+decimalFormat.format(radius[i]));
                System.out.println("Mass="+decimalFormat.format(mass[i]));
                System.out.println("Gravity="+decimalFormat.format(gravity[i]));
                System.out.println();
            }


          }


      }
}