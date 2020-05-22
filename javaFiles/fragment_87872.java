public class TowersOfHanoi {
   public static void main(String[] args) {
      int first = 1, second = 2, third = 3;
      int disk = 5; // or take user input
      move(disk, first, third);
   }

   public static void move(int disks, int first, int second, int third) {
      if (disks > 0) {
              move(disks - 1, first, third, second); // source = first, dest = second
              System.out.println("Move disk from peg " + first+ " to " + third);
              move(disks - 1, second, first, third);  // source = second, dest = third
         }
   }
}