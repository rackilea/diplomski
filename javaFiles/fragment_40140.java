HashMap<String, String> map = null;

for (int i = 0; i < user.length(); i++) {
    map = new HashMap<String, String>();

    map.put(TAG_Latitude + i, latitude);
    map.put(TAG_Longitude + i, longitude);
    map.put(TAG_Speed + i, speed);
    map.put(TAG_Vehicle_Status + i, sleepstring);

    vehiclehistory.add(i, map);
}