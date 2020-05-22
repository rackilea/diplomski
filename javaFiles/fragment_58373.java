public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int[] numbers = new int[20];

    boolean mustKeepSerie = true;
    int sum = 0, input = 0, counter = 0;

    System.out.print("Series ");
    while ((input = in.nextInt()) >= 0 && counter < 20) {
        numbers[counter] = input;
        sum += numbers[counter];

        // mustKeepSerie condition
        boolean hasbignumber = false;
        if (numbers[counter] > 15) {
          hasbignumber = true;
        }
        if (sum > 50 || hasbignumber) {
          mustKeepSerie = false;
        }
        counter++;
    }

    if (mustKeepSerie) {
       // do your processing     
    }

   }