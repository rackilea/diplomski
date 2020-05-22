interface ReturnsANumber {
    int theNumber();
    int getIt();
}

public int getIt() {
    ReturnsANumber outer = this;

    ReturnsANumber w = new ReturnsANumber() {
        public int theNumber() {
            return 1;
        }

        public int getIt() {
            return  outer.theNumber();
        }
     };

     return w.getIt();
 }