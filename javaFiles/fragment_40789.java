System.out.println("Type a power: ");
        int power = Integer.parseInt(reader.nextLine());
        int number = 2;
        int i = 0;
        double sum = 0;
/*Remove this -------->  while(power <= i) {*/
        while (i <= power) {//it should be this
/*Remove this ------->   Math.pow(number, i);*/
            sum = sum + Math.pow(number, i);
            i = i + 1;
        }
        System.out.println("The sum is: " + sum);