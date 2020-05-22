int[][] array = // Something useful

    Rational[] rs = new Rational[4];
    for(int i=0;i<array.length;i++){
      for(int j=0;j<array[i].length;j++){
        rs[i*2+j] = r.multipleValue(array[i][j]);
      }
    }

    return new Matrix(rs);