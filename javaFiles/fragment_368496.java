public int search(int lookFor){
        int res = -1;//not found
        if(lookFor == one){
            res = one;
        }
        else if(lookFor == two){
            res = two;
        }
        else if(lookFor == three){
            res = three;
        }
        return res;        
    }