public class FindConsecutiveNumber{

public static void main(String[] args){
    int i,j;
    int[] c = {17,39,78,324,43,33,234,99,34,555,39,78,324,43,45,92};
    for( i = 0; i < c.length; i++){
        for( j = i+1; j < c.length-i; j++)
        {
           if(c[j] == c[i]){

                  if(c[j+1] == c[i+1] && c[j+2] == c[i+2] && c[j+3] == c[i+3])
                   {
                       System.out.println(c[i] + "," +c[i+1] + ","+c[i+2] + ","+ c[i+3] );
                       break;
                   }

           } 
        }


    }
}

}