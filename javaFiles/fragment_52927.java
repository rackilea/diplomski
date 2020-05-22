public static void main(String[] args) {


int count;
Scanner in = new Scanner(System.in);
System.out.println("Please enter number");

count = in.nextInt();

        int[] fib = new int [count+1];
        fib[0] = 1;
        fib[1] = 1;

        for (int i=2; i <= count; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }

         for(int i=0; i <= count; i++){
             System.out.print(fib[i] + " ");

         }
            }
        }