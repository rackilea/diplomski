import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.JsonAdapter;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class GsonApp {

    public static void main(String[] args) throws Exception {
        List<BaseBean> children = Arrays.asList(new BaseBean(), new ChildBean(), new ChildBean2());
        BaseBeanHolder baseHolder = new BaseBeanHolder(children);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        System.out.println(gson.toJson(baseHolder));
    }
}

class BaseBean {
    String baseField = "base";
}

class ChildBean extends BaseBean {
    String childField = "child";
}

class ChildBean2 extends BaseBean {
    int bean2Int = 356;
}

class BaseBeanHolder {

    @JsonAdapter(TypeAwareListJsonSeserializer.class)
    private List<? extends BaseBean> beans;

    // getters, setters, toString
}