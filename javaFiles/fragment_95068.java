public class RandomNumbers {
    public static void main(String[] args){
        for(int i = 0; i < 5; i++){
            System.out.println((int)((Math.random() * 81) + 20));
        }
    }
}