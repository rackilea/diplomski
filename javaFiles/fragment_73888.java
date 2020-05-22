public class first{
    static void afficher(int a){
        for(int i = 1; i <= a; i += 2) {
            for(int j = i; j <= a; j += 2){
                System.out.print(j);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}