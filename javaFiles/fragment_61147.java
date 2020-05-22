import scala.Some;
import scala.collection.JavaConversions;
import java.util.Arrays;

public class Test {

    public static void main(String[] args){
    AddressView billToAddress = new AddressView
        (new Some<>(BusinessFieldValue.ShipToAddressId),
            shipAddress,
            JavaConversions.asScalaBuffer(Arrays.asList("BILLING")));

    }

}