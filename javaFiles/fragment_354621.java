if (x<tx)
            return 1+ count(x+1, y, tx, ty);
        if (x<tx)
            return 1+ count(x+2, y, tx, ty);
        if (y<ty){
            return 1+ count(x, y+1, tx, ty);
        }
        return 0;