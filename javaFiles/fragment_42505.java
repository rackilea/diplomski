public Television(int chLimit) {

if (chLimit < 0) {
    throw new IllegalArgumentException("...");
    }
    else {
          this.chLimit = chLimit;
    }