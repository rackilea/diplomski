public class main{
  public static void main(String[] args){
    int max = 5;
    for(int i = 1; i < max; ++i){
        for(int j = i; j < max; ++j)
            System.out.print(" " + j);

        for(int k = 1; k < i; ++k)
            System.out.print(" " + k);

        System.out.println();
        }
    }
}