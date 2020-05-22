// This could be double or Double
double res = Newtons_method(pmt, guess);
// This could be res==null check or Double.isNaN(res) call
if (!checkResult(res)) {
    // Do something else
}
// Do regular processing