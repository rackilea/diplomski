else {
                 compressed = compressed + ch;
                if(counter != 1){
                   compressed = compressed + counter;
                }
                ch = original.charAt(i);
                counter = 1;
             }