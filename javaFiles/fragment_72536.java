import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Fee {
    private String name;
    private int fee;

    private static Map<Integer, Function<Fee, Object>> getterIndex = new HashMap<>();
    static {
        getterIndex.put(0, Fee::getName);
        getterIndex.put(1, Fee::getFee);
    }

    public String getName() {
        return name;
    }

    public Fee setName(String name) {
        this.name = name;
        return this;
    }

    public int getFee() {
        return fee;
    }

    public Fee setFee(int fee) {
        this.fee = fee;
        return this;
    }

    public Object getValue(int index) {
        return getterIndex.get(index).apply(this);
    }

    public static void main(String[] args) {
        Fee fee = new Fee().setName("Barry").setFee(1000);
        System.out.println("name: " + fee.getValue(0));
        System.out.println("fee : " + fee.getValue(1));
    }
}