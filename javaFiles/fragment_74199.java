public class Diamond {

    @Property
    @Persist
    private String diamond;


    @SetupRender    
    init(){
         int n,i,j,k;

     do {  

      n = (int)(Math.random() * 10 + 3); 

      }while(n % 2 == 0);

      diamond += ""+n+"<br\/>";

      System.out.println();   

     for (i = 1; i <= n; i++){

        for (k = n; k > i; k--)
          diamond += "-";

        for (j =1; j <= i; j++)
             diamond += "*"+"-";


       diamond += "<br\/>";

        }

     for (i = n; i > 0; i--){

        for (k = n; k > i; k--)
          diamond += "-";

        for (j =1; j <= i; j++)
               diamond += "*"+"-";

              diamond += "<br\/>";

        }
}
}