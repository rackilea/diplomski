public class Test {

public static int findMatchCount(final String [] a,final String [] b){
    int matchCount = 0;

    for(int i = 0, j = 0;i < a.length && j < b.length;){
        int res = a[i].compareTo(b[j]);
        if(res == 0){
            matchCount++;
            i++;
            j++;
        }else if(res < 0){
            i++;
        }else{
            j++;
        }
    }
    return matchCount;
}

public static void main(String[] args){ 
    String[] a = {"apple", "apple"};
    String[] b = {"apple", "apple"};
    System.out.println(findMatchCount(a,b));

}
}