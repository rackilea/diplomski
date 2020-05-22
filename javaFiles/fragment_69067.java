public static void main(String[] args) throws IOException{
    int[] date = new int[10];      // as mentioned above, a fixed size array will limit you - but if 10 is what you want, then this is what you need
    int i = 0;

    System.out.println("Please enter " + date.length + " numbers");  // just some output to tell the user that the program has started and what to do next
    Scanner in = new Scanner(System.in);      // perfect
    // if you absolutely want your array filled, check if you reached the end of your input to avoid IndexOutOfBoundsExceptions.
    // in.hasNext() will check for ANY input, which makes it easier to handle unwanted user input
    while(i < date.length && in.hasNext()){   
        if(in.hasNextInt()){        // here you check if the input starts with a number. Beware that "1 w 2" is valid too!
            date[i] = in.nextInt();
            i++;   
        }else{
            // this is to advise the user of an input error
            // but more importantly, in.next() will read the invalid input and remove it from the inputstream. Thus your scanner will continue to read the input until it ends
            System.out.println("sorry \"" + in.next() + "\" is not a valid number"); 
        }
    }
    System.out.println("your input:");  
    for(i = 0; i < date.length; i++){    // you don't need any advanced loops, it is perfectly fine to use indexed loops. Just try to make your break condition more dynamic (like checking the length of the array instead of a constant value)
        System.out.println(date[i]);
    }
}