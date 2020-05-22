private void getLogin(JSONObject response) {
     LoginBean loginBean=null;
    if (response != null){
        try {
            loginBean = new LoginBean();
            JSONObject jsonObject = response.getJSONObject("data");
            loginBean.setUser_id(jsonObject.getString("user_id"));
            loginBean.setFull_name(jsonObject.getString("full_name"));
            loginBean.setDisplay_name(jsonObject.getString("display_name"));
            loginBean.setUser_image(jsonObject.getString("user_image"));
            loginBean.setGender(jsonObject.getString("gender"));
            loginBean.setAuthorization_key(jsonObject.getString("authorization_key"));

            //  signUpArrayList.add(signUpBean);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // dataBean.setSignUp(signUpArrayList);
    }
    Toast.makeText(getApplicationContext(),"Hello"+loginBean.getFull_name(),Toast.LENGTH_LONG).show();

}