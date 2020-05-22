int n = input.nextInt();
        int sum = 0;
        int addOrDedduct = 1;
        for (int i = 1; i <= n; i++ ) {
                if( addOrDedduct % 4 == 1 )
                    sum = sum + addOrDedduct;
                else
                    sum = sum - addOrDedduct;
                addOrDedduct+=2;
        }
        System.out.println(sum);