if (row+1>0 && row+1<mat.length) //valid move down
        if (nextVal==mat[row+1][clmn])
            return isPath (mat, val+1, row+1, clmn);

    if (row-1>0 && row-1<mat.length) //valid move up
        if (nextVal==mat[row-1][clmn])
            return isPath (mat, val+1, row-1, clmn);

    if (clmn+1>0 && clmn+1<mat.length) //valid move right
        if (nextVal==mat[row][clmn+1])
            return isPath (mat, val+1, row, clmn+1);

    if (clmn-1>0 && clmn-1<mat.length) //valid move left
        if (nextVal==mat[row][clmn-1])
            return isPath (mat, val+1, row, clmn-1);

    return false;