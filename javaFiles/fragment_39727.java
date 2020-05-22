public class WordSort {

    public static void main(String[] args) {
        int listSize = 0;

        String[] oneArray = {"a1","b1","c1","d1","e1","f1","g1","h1","i1","j1","k1","l1","m1","n1","o1","p1","q1","r1","s1","t1","u1","v1","w1","x1","y1","z1","a2","b2","d2","g2","n2","l2","z2","v2","g3","h3","p0","h9","r5","t3","o9","l7","h6","f5","q5",};

        for (int i = 0; i < 26; i++) {

            int sizeCheck = 0;

            for (int j = 0; j < oneArray.length; j++) {

                if (oneArray[j].charAt(0) == (char) (i + 97)) {
                    sizeCheck++;
                }
                if (sizeCheck > listSize) {
                    listSize = sizeCheck;
                }
            }
        }

        String[][] twoArray = new String[26][listSize];

        for (int i = 0; i < 26; i++) {
            int k = 0;
            for (int j = 0; j < oneArray.length; j++) {
                if (oneArray[j].charAt(0)==(char)(i+97)){
                    twoArray[i][k++]=oneArray[j];
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < listSize; j++) {
                System.out.println(twoArray[i][j]);
            }
        }
    }
}