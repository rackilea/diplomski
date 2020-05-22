public static void main(String[] args) {
   // TODO code application logic here
   Scanner s = new Scanner(System.in);

   String text = s.nextLine();


   String[] entries = text.split(" ");
   int[] nums = new int[entries.length];

   for(int i = 0; i < entries.length; i++) {
     nums[i] = Integer.parseInt(entries[i]);
   }
   for(int i = entries.length-1; i >= 0; i--) {
     System.out.println(nums[i]);
   }
}