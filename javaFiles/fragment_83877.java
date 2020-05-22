public class CryptoCurrency {

        @SerializedName("BTC")
        @Expose
        private BTC BTC;
        @SerializedName("ETH")
        @Expose
        private ETH ETH;

        public BTC getBTC() {
            return BTC;
        }

        public void setBTC(BTC BTC) {
            this.BTC = BTC;
        }

        public ETH getETH() {
            return ETH;
        }

        public void setETH(ETH ETH) {
            this.ETH = ETH;
        }

    class ETH {
      ...
    }

    class BTC {
       ...
    }

}