class RhombusNumbers{

    public static void main(String[] args){
        String left = "";
        String right = "";
        int max = 8;
        for(int i = 1; i <= max; i++){
            System.out.println(left + i + right);
            left+=i;
            right = i + right;
        }
    }

}