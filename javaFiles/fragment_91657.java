public class JavaApplication20 {

    public static void main(String[] args) {
        // TODO code application logic here

        String test1 = "";
        String[] test = {"this","this2"};
        int length = test.length;
        //System.out.println("Length :"+length);
        for(int i=0; i<length; i++){
            //System.out.println(test[i]);
            test1 += test[i]+",";
        }
        int len = test1.length();
        String str = test1.substring(0, len-1);
        System.out.println("String :"+str);
    }

}