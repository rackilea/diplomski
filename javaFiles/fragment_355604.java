public class BitCoinPricer {
    BitCoinValueService valueService;

    public BitCoinPricer(BitCoinValueService valueService){
        this.valueService = valueService; 
    }

    public double convertEuro (){
        double euroVal = 1.227481; 
        double result = valueService.findPrice() * euroVal;
        return result;
    }
}