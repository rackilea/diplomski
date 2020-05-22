try{
        int[] a = {1,2,3,4,5,6,7};
        int[] b = {5,6,7,8,9,10};
        int[] c = new int[a.length+b.length];
        int[] fin = new int[a.length+b.length];
        int i = 0;
        for(int j : fin){
            fin[i++] = -1;
        }
        i = 0;
        for(int j : a){
            c[i++] = j;
        }
        for(int j : b){
            c[i++] = j;
        }
        boolean check = false;
        for(int j = 0,k = 0; j < c.length; j++){
            for(int l : fin){
                if( l == c[j] )
                    check = true;
            }
            if(!check){
                fin[k++] = c[j];
            } else check = false;
        }

    } catch(Exception ex){
        ex.printStackTrace();
    }