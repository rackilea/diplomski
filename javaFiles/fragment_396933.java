import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Slave1 implements Slave {
    @Value("${slave1.order}")
    private int myOrder;

    @Override
    public int getOrder() {
        return myOrder;
    }
}