wifi_SSID = wifiList.get(position).SSID;
// ... other code ...
SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPref.edit();
editor.putString("saved_wifi_ssid", wifi_SSID);
editor.commit();