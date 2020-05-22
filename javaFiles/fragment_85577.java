public class HolderConfigBuilder {

public static HolderConfig build(JsonObject holderConfigJson) {

    HolderConfig configHolderInstance = null;         

    Gson gsonInstance = null;

    gsonInstance = new GsonBuilder().create();

    configHolderInstance = gsonInstance.fromJson(holderConfigJson,HolderConfig.class);

    return configHolderInstance;
  }
}