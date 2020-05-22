class MyResponseListener implements Response.Listener<JSONObject> {
      boolean isGoodParam;

      MyResponseListener(boolean isGoodParam) {
         this.isGoodParam = isGoodParam;
      }

      public isGoodParam() {
         return this.isGoodParam;
      }

       @Override
        public void onResponse(JSONObject response) {
            //use your param
            if(this.isGoodParam) {
                doStuff();
            }
       }
}