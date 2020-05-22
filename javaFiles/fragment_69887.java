import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by yprajapati on 19/09/2019.
 */

public class MainApp {
    public static void main(String[] args) throws JsonProcessingException {
        Test test = new Test();
        test.setDate(1568866827596L);

        System.out.println(new ObjectMapper().writeValueAsString(test));
    }
}