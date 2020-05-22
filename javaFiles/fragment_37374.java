public void Buzz(int limit){
    for(int i = 1; i<limit; i++){

        boolean fizzOrBuzz = false;

        if(i % 3 == 0){
            fizzOrBuzz = true;
            System.out.print("Fizz");
        }

        if(i % 5 == 0){
            fizzOrBuzz = true;
            System.out.print("Buzz");
        }

        if (fizzOrBuzz) {
            System.out.println();
        } else {
            System.out.println(String.valueOf(i));
        }
    }
}