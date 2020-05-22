final class Util
{
    public static void shuffle(int[] num){
        Random rnd = new Random();
        for(int x=0; x<num.length; x++)
            swap(num, x, rnd.nextInt(num.length));
    }

    public static void swap(int[] num, int a, int b){
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }

    public static int[] createOrderedArray(int size, int startValue){
        int[] num = new int[size];
        for(int x=0; x<num.length; x++)
            num[x] = x+startValue;      
        return num;
    }

    //Return TRUE if array vs arrays is COMPLETELY different
    public static boolean compare2DArray(int[] num1, int[][] num2, int start, int end){
        for(int x=start; x<end; x++)
            if(!compareArray(num1, num2[x]))
                return false;
        return true;        
    }

    //Return TRUE if arrays are COMPLETELY different 
    public static boolean compareArray(int[] num1, int[] num2){
        if(num1.length != num2.length)
            return false;
        for(int x=0; x<num1.length; x++)
            if(num1[x] == num2[x])
                return false;
        return true;        
    }

    public static void print(int[][] num){
        for(int x=0; x<num.length; x++){
            for(int y=0; y<num[0].length; y++)
                System.out.print(num[x][y] + " ");
            System.out.println(""); 
        }                           
    }
}