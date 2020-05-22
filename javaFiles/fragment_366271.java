public void getSaveData() {
    SharedPreferences preferences = this.getActivity().getSharedPreferences("Saved_data", Context.MODE_PRIVATE);
    String client_id = preferences.getString("client_id", "client_id");
    String client_secret = preferences.getString("client_secret", "client_secret");
    String access_token = preferences.getString("access_token", "access_token");
    String refresh_token = preferences.getString("refresh_token", "refresh_token");
    Toast.makeText(getActivity(), client_id + " " + client_secret
            + " " + access_token + " " + refresh_token,Toast.LENGTH_SHORT).show();
}}