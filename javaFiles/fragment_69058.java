public class Rate {
       public enum RateSource {
          EMPTY,
          DEFAULT,
          EDITED
       };

       private double rate;
       private RateSource rateSource;

       // construct an empty rate
       public Rate() {   
          this.rateSource=RateSource.EMPTY;
       }


       // construct a known rate
       public Rate(double defaultRate) {   
          this.rate=defaultRate;
          this.rateSource=RateSource.DEFAULT;
       }

       // call to set a rate, aka. edit
       public void setRate(double rate) {
          this.rate=rate;
          this.rateSource=RateSource.EDITED;
       }

       public RateSource getRateSource() {
          return rateSource;
       }
    }
}