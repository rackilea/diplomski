for(d=start;d<=end;d++) { 
        b=0; 
        for(c=1;c<=d;c++){ 
            if(d%c==0) 
                b=b+1;
        } 
        if(b==2){ 
            primes=primes+1;
            if(d!=start){
                System.out.printf("%4d", d);
            }
        }else{
            if(d!=start){
                System.out.printf("   -");
            }
        }
        if(d%10==0&&d!=start){
            System.out.printf(" | ");
            System.out.printf("%4d", d);
            System.out.println();
        }