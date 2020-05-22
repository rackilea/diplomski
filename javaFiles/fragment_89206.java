// first line
            for (int i = 0; i < denom_sum.length; i++) {
                num_sum[i] = num_sum[i] + num[i];
                System.out.printf("%d   ", num_sum[i]);
                numeratorSum = numeratorSum + num_sum[i];
            }
            System.out.printf("     %d \n", numeratorSum);
            // second line
            for (int i = 0; i < denom_sum.length; i++) {
                System.out.printf("--- %c", ch);
            }
            System.out.printf("=\t   --- \n", ch);
            // third line
            for (int i = 0; i < denom_sum.length; i++) {
                denom_sum[i] = denom_sum[i]+ denom[i];                    
                System.out.printf("%d    ", denom_sum[i]);
                denominatorSum = denominatorSum + denom_sum[i];
            }
            System.out.printf("\t%d \n", denominatorSum);