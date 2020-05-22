public static void maximizeweight(int[] weight, int[] A){
        Random r = new Random();
        for(int i=0;i<A.length;i++){
            while(totalweight(weight,A) < 630){
                int random = r.nextInt(A.length);
                if(A[random]==0)
                    A[random] += 1;
            }
        }
    }