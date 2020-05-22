Gson gson = new Gson();
ArrayList<MyDevice> yourArray = gson.fromJson(jsonString, new TypeToken<List<MyDevice>>(){}.getType());


public class MyDevice {

    public String name;
    public int deviceId;
    public String serialNo;
    public String deviceType;
    public boolean enabled;

   //Setters and Getters
}