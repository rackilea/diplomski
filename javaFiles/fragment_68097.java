if(pixels[i1][j1] != pixels[i1+r][j1]
                || pixels[i1][j1] != pixels[i1-r][j1]
                || pixels[i1][j1] != pixels[i1][j1+r]
                || pixels[i1][j1] != pixels[i1][j1-r]){
            drawCircle(i1,j1,r,img,g2);
        }