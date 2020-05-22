public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   int[] ages = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
   int num = getGreaterNum(ages, 60);
   System.out.println(num);
}

public static int getGreaterNum(int[] nums, int condition) {
   int greater= 0;
   for(int num : nums) {
       if(num > condition) {greater++;}
   }
   return greater;
}