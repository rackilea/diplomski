public class Methods3 {
    static final int chars = Character.MAX_VALUE;   
    static char least(String str) {    
        int[] bro = new int[chars];    
        int j;    
        for (j = 0; j < str.length(); j++) {            
            (bro[str.charAt(j)])++; // made the array
        }
        int min = Character.MAX_VALUE;
        for (int x = 0; x < bro.length; x++) {
            if ((bro[x]) <= min && bro[x] > 0)  {
                min = x; // finding the smallest number of times
            }
        }

        return (char) min;
    }

    public static void main(String[] args) {    
        String txt = "yooooo bbaa ccoo";    
        char rez = least(txt);    
        System.out.println(rez);
    }
}