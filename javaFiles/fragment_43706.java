import java.util.Random;
 class Test{
     public static void main(String []args){
            Random rnd=new Random();

            for(int i=0;i<100;i++){
                int day=rnd.nextInt(30)+1;
                System.out.println("Random Day ("+(i+1)+"):" + day);
            }
     }
}