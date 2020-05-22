do
        { 
            if(num % 2 == 0) 
                num /= 2; 
            else 
                num = 3 * num + 1; 
                System.out.print(EasyFormat.format(num,4,0)); 

        } while (num != 1);