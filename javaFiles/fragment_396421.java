public class Server {
    public static String getEven(int[] array){
        String result = "";
        for(int i=0; i<array.length; i++){
            if(array[i]%2 ==0){
                if(result.length() != 0)
                {
                    result = result + ", ";
                }
                result = result + array[i];
            }
        }
        return result;
    }

    public static String getOdd(int[] array){
        String result = "";
        for(int i=0; i<array.length; i++){
            if(array[i]%2 !=0){
                if(result.length() != 0)
                {
                    result = result + ", ";
                }
                result = result + array[i];
            }
        }
        return result;
    }

    public static String getNeg(int[] array){
        String result = "";
        for(int i=0; i<array.length; i++){
            if(array[i]<0){
                if(result.length() != 0)
                {
                    result = result + ", ";
                }
                result = result + array[i];
            }
        }
        return result;
    }
}