public static void main(String[] args){
            String url = "....";
            String url1 =".....";

            String response  = getURLResponse(url);
            String response1  = getURLResponse(url1);

            JSONObject obj_JSONObject = new JSONObject (response);
            JSONObject obj_JSONObject1 = new JSONObject(response1);
...
}