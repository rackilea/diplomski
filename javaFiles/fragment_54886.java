public class ConfigValues {
    public ConfigValue[] configValues;
}

public class ConfigValue {
    public String key;
    public String defaultValue;
    public String value;
}

public static void main(String[] args) {
    String firstJson = "{\"configValues\":[{\"key\":\"radiusMeters\",\"value\":\"200\"}]}";
    String secondJson = "{\"configValues\":[{\"key\":\"redeemExpirationMins\",\"defaultValue\":\"300\"},{\"key\":\"radiusMeters\",\"value\":\"200\",\"defaultValue\":\"400\"}]}";

    Gson gson = new Gson();

    ConfigValues firstConfigValues = gson.fromJson(firstJson, ConfigValues.class);
    ConfigValues secondConfigValues = gson.fromJson(secondJson, ConfigValues.class);

    System.out.println(firstConfigValues);
    System.out.println(secondConfigValues);
}