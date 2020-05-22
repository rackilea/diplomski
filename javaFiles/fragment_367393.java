public static void main (String[] args){
            Scanner input = new Scanner(System.in);
            int[] list;
            list = new int[10000];
            int sum = 0;
            int avr = 0;
            int x = 0;
            int number;

            while (x <= list.length && (number != 0 || x==0)){
                 System.out.print("Add number " + (x+1) + ": ");
                 number = input.nextInt();
                 list[x] = number;
                 x++;                     
            }

            for(int i = 0; i < x; i++){
                 sum += list[i];
            }

          }