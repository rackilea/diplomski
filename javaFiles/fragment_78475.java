public class Model {
    List<Model1> shipping_methodsx;

    class Model1 {
        String title;
        String sort_order;
        boolean error;

        List<Model2> quote;
        List<Model3> quote1;
    }

    class Model2 {
        @SerializedName(value = "flat", alternate = {"free", "pickup"})
        Model3 key;
    }

    class Model3 {
        String code;
        String title;
        String cost;
        String tax_class_id;
        String text;
    }
}

public static String removeSomeJson(String json) {
    Gson gson = new Gson();

    Model ret = gson.fromJson(json, Model.class);

    for(Model.Model1 model1: ret.shipping_methodsx){
        model1.quote1 = new ArrayList<>();
        for(Model.Model2 model2 : model1.quote) {
            model1.quote1.add(model2.key);
        }
        model1.quote = null;
    }

    return gson.toJson(ret);
}