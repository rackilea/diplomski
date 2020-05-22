for (int i = 0; i < al; i++) {
        flagDubl = false;
        //!!here I've changed your code !!
        for (int j = 0; j < i ; j++) {
            // duplicates exist
            if (a[i] == a[j] ) {
                flagDubl = true;
                break;
            }
        }
        //ignore if it is dublicate
        if (!flagDubl) {
            for (int j = 0; j < bl; j++){
                if (a[i] == b[j]) {
                    //it is in both arrays;
                    System.out.print( a[i] + " ");
                    break;
                }

            }
        }
    }