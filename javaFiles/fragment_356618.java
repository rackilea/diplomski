public static int Sum(int a) {
        int sum = 0;
        int rest = 1;
        while(rest!=0){
            rest = a % 10;
            a = a / 10;
            sum = sum + rest;           
        }

        return sum;
    }