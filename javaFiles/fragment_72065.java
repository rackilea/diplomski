if (id==R.id.Submit){
        int numClickedInA=0;
        int numClickedInB=0;
        for(int i=0; i<colA.length; i++ ){
            if (((colA[i].getText()==("0"))) || ((colA[i].getText()==("1")))){
                ++numClickedInA;
            }
        }

        for(int i=0; i<colB.length; i++ ){
            if (((colB[i].getText()==("0"))) || ((colB[i].getText()==("1")))){
                ++numClickedInB;  
            }
        }

            if((numClickedInA==colA.length) && (numClickedInB==colB.length)){
                // All buttons have been clicked
            }
            else{
                System.out.println("Please click all buttons.");
            }
    }