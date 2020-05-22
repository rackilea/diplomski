int i = 0;
  for (int k = 0; k < x.length; k++) {
    if(x[k] == 1) {
        z[i] = a[k];
        i++; //advance the output index
    }
  }