for (double power = 1; power <= 5; power++) {

        double sum = 0;
        for (double n = 1; n <= 10; n++) {
            double result = (Math.pow(n, power));
            sum=sum+result;

        }
        System.out.println(sum);
    }