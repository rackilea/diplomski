while ((input = in.nextInt()) != 0) {

        if (counter == 0)
          small = large = input;

        if (input != 0)
            sum = input + sum;
            counter++;

        if (input > large)
            large = input;

        if (input < small)
            small = input;

        if (input % 2 == 0)
            even = even + 1;
        else
            odd = odd + 1;

        }