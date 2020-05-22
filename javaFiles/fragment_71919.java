Arrays.sort(banding);
setText(banding);

void setText(Banding[] banding) {
  final int loc = banding.length - 1;

  // if the highest is what we want, set and return
  if (banding[loc].getKekTotal().equals("CUKUP")) {
    untungtertinggi.setText(Double.toString(banding[loc].harga));
    return;
  }


  // we run until one before the start of the array, as we check for the 
  //   previous value; if we meet the criteria of [i] being LEBIH, and [i - 1]
  //   being CUKUP, then we set the value and return
  for (int i = loc; i > 0; --i) {
    if (banding[i].getKekTotal().equals("LEBIH") &&
         banding[i - 1].getKetTotal().equals("CUKUP")) {
      untungtertinggi.setText(Double.toString(banding[i - 1].harga));
      return;
    }
  }

  // no specific value found
  untuntertinggi.setText(Double.toString(0.0));
}