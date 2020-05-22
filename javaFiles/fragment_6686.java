import java.util.HashMap;
import java.util.Map;

public class DataDefaults
{

    Map<PlayerDefaults, Object> playerData = new HashMap<PlayerDefaults,Object>();

    public DataDefaults(final String name)  {
        if (playerData.isEmpty())
        for (PlayerDefaults pd : PlayerDefaults.values()) {
            playerData.put(pd, pd.value);           
        }
        playerData.put(PlayerDefaults.Name, name);      
    }

    void close() {
        for(Map.Entry<PlayerDefaults, Object> entry : playerData.entrySet()) {
            System.out.println(entry.getKey().name() + ": " + entry.getValue());
        }
    }

    public static enum PlayerDefaults { 
        Name("$Name$"),
        Money(2000),
        Warnings(0);

        private Object value; 
        private PlayerDefaults(Object value) {
            this.value = value;
        }       

        Object getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        new DataDefaults("WTF");
    }
}