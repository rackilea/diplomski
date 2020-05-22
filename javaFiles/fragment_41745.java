public class test {

    public int sumOfDigits(String s){
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            char cur = (char)(s.charAt(i) - '0'); //Java autocasts to int when you subtract

            if (cur >= 0 && cur <= 9){
                sum += cur;
            }
        }


        return sum;

    }

}