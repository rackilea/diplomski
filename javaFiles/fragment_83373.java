int result = -1;
    int len = s.length();
    for(int i = len; i > 0; i--){           
        int n = len/i;
        if( n * i == len){
            boolean valid = true;
            String part = s.substring(0,n);
            for(int j = 1; j < i; j++){

                if(!s.substring(j*n,j*n+n).equals(part)){
                    valid = false;
                    break;
                }

            }
            if(valid){
                result = i;
                break;
            }

        }


    }