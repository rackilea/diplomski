class RhombusNumbers{

    public static void main(String[] args){
        String left = "";
        int max = 8;
        for(int i = 1; i <= max; i++){
            System.out.println(left + i + new StringBuilder(left).reverse().toString());
            left+=i;
        }
    }

}