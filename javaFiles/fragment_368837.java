public static void main(String[] args) {
    String content = "03000001da00000001666666";

    String firstIndex = content.substring(0, 10);
    String requireIndex = content.substring(10,18);
    String lastIndex  = content.substring(18);
    for(int i = 0; i <= 10;i++){
        System.out.printf("%s%08d%s%n",firstIndex, Integer.parseInt(requireIndex)+i, lastIndex);
    }
}