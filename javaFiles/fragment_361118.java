if (len > 3 && len % 2 == 0) {
      // if len is 4 it becomes 5, if it is 5 it stays as is
      // if len is 6 it becomes 7 and an exception occurs
      len++;
   }
   ...
   if (len > 3) {
         // puts the thousand part in tmp
         // so if num is 9000, len is 5 and tmp is 9 (9000/10^3)
         // if num is 99000, len is 5 and tmp is 99 (99000/10^3)
         // and if num is 999000, len is 7 and tmp is 9 instead of 999 (999000/10^5)
         tmp = (num / (int)Math.pow((double)10,(double)len-2));
         // If tmp is 2 digit number and not a multiple of 10
         // So, if tmp is 11 to 19 (num was 11000 to 19999) it enters the if
         if (tmp / 10 == 1 && tmp%10 != 0) {
            // if tmp is 11 tmp % 10 is 1 and the wordarr11[1] is eleven etc.
            sb.append(wordarr11[tmp % 10]) ;
         } else {
            // if tmp is not 11 to 19 it enters here
            // this means if tmp is 1 to 9 for num 1000 to 9999
            // if tmp is 10 for num 10000 to 10999
            // if tmp is 20 to 99 for num 20000 to 99999
            // if tmp is 100 to 999 for num 100000 to 999999

            // wordarr10 contains the dozens
            // if tmp is 10 this will be ten, if it is 20 this will be twenty etc.
            // if tmp is 1 to 9 tmp / 10 will return 0 and sb will append an empty string (wordarr10[0])
            sb.append(wordarr10[tmp / 10]);

            // wordarr1 contains the units
            // if tmp is 1 to 9 then tmp % 10 will return the tmp as it is
            // if tmp is 10 or 20 tmp % 10 will return 0 and append the empty string
            // if tmp is 23 tmp % 10 will return 3 and append the word three
            sb.append(wordarr1[tmp % 10]);
         }
         // if tmp is a positive numbers... we know it is but ok...
         // we append the word hundrend if len is 2 or three, which is impossible because we are in the if(len > 3) branch
         // if original len was 4 it have become 5 earlier so
         // if len is 5 the len / 2 is 2 and we append the word thousand
         // if len is 7 len / 2 is 3 and an out of bounds exception gets thrown
         if (tmp > 0) {
            sb.append(wordarr100[len / 2]);
         }
         // finally we remove the part of num that we have printed in order to print the rest
         // so if num is 1123 then it will become 123
         // or if it is 12123 it will become again 123 (because len is 5)
         // if len is 7 this will fail and for example 123123 will become 23123
         num = num % (int)(Math.pow((double)10,(double)len-2));
         // if len is 5 then we make it three in order to run the else branch and print the rest part
         // if len was 7 this would make it 5 and the same branch would run again which I guess is also wrong
         len = len-2;