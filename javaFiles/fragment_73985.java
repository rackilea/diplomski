import java.util.Random;

public class Zadanie5_3 {

    public static void main(String[] args){
        Random rand = new Random();
        int[] tab = new int[20];

        for(int i = 0; i <= 18; i++){
            tab[i] = rand.nextInt();
        }   

        for(int j = 19; j >= 9; j--){
            tab[j] = tab[j-1];
        }

        tab[9] = -1;

        // print
        for(int i = 0; i <= 18; i++){
            System.out.println(tab[i]);
        } 
    }   

}

result:

1956305001
-2096126360
98350219
1446603176
1822536231
-585584710
1907161554
-1249344271
330285354
-1
-2035667564
935350135
178577755
1025860367
-965180067
1164224066
1726709678
1615705033
-1258924041