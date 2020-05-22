public class Main {
     public int Search(int[] a, int x) {
         int low = 0;
         int high = a.length - 1;
         Boolean search=false;
         while (low <= high && !search) {
            int mid = (low + high)/2;
            if (a[mid] == x) {
                search=true;
                return mid;
            }
            else if (a[mid] < x) low = mid + 1;
            else high = mid - 1;
         }
         return -1;
     }


     public static void main(String[] args) {
          Main bin = new Main();
          int[] a ={ 2, 8,12,14,16,19,24,28,31,33,// 0-9
             39,40,45,49,51,53,54,56,57,60,// 10-19
             63,69,77,82,88,89,94,96,97};  // 20-28
          Scanner input = new Scanner(System.in);
          System.out.println("Enter the number you whould like to search !");
             int n=input.nextInt();
             int index=bin.Search(a,n);
             if(index<0) { //-1 means that the element doesn't exist in the array 
                System.out.println("This number doesn't exist in the array "); 
             } else { //The "}" before the else was missing
                System.out.println("The index of the number "+n+" in the array is :"+ index);
             }

     }
}