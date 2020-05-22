for(int i = 0; i < al; i++) {
        //let al=5, so index of a will be 0..4
        //so for first iteration i=0
        //so a[5-0] i.e: a[5] where 5 is index out of bound
        a[i] = a[al - i];
    }