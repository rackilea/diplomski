public class Integer {
    private int a, b;
    private boolean flipped;

    public Integer(int _a, int _b){
        a = Math.min(_a, _b);
        b = Math.max(_a, _b);
        flipped = b < a;
    }

    public void markOff(boolean [] arr){
        for(int i = 0; i < arr.length; i++){
            if(a <= i && i <= b){
                arr[i] = arr[i] || !flipped;
            }else{
                arr[i] = arr[i] || flipped;
            }
        }
    }
}