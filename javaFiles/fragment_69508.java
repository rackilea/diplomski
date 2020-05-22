int sum = 1;
int input;

System.out.print("Enter a number: ");
input = console.nextInt();

ArrayList<Integer> fib = new ArrayList<Integer>();
ArrayList<Integer> out = new ArrayList<Integer>();
ArrayList<Integer> fib2 = new ArrayList<Integer>();

fib.add(0);
fib.add(1);

fib2.add(0);
fib2.add(1);
if (input > 0) {

    if (input <= 7) { // for numbers 1,1,2,3,5,8 
        for (int i = 2; i < input; i++) {
            fib.add(i, fib.get(i - 1) + fib.get(i - 2));
            out.add(i, factorial(fib.get(i)));

        }
    } else { // this is for the 2 digit numbers 13,21,34,55,89
        for (int i = 2; i < input; i++) {
            fib.add(i, fib.get(i - 1) + fib.get(i - 2));
            fib2.add(i, fib2.get(i - 1) + fib2.get(i - 2));
        }
        for (int i = 2; i < input; i++) {
            fib.add(i, separate(fib.get(i)));
            fib2.add(i, separate2(fib2.get(i)));
            out.add(i, factorial(fib.get(i)) + factorial(fib2.get(i)));
        }

    }

    for (int i : out) {
        sum = sum + i;
    }
    System.out.println(sum);
}