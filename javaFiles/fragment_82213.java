else {
                if(counter != 1){
                   compressed = compressed + counter;
                }
                 compressed = compressed + ch;
                ch = original.charAt(i);
                counter = 1;
             }