import com.test.Main;
public class InvokeTransmission {

    public void invoke(String params){
        String[] res = params.split("\\s+");
        Main.main(res);
    }
}