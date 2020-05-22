@RequestMapping(value = {"/Oats-Exception-summary/"}, method = RequestMethod.POST)
     public ResponseEntity<List<OatsExceptionSummary>> OatsExceptionSummaryPost(
             @RequestBody Map payload)throws SQLException,JSONException,Exception {
        JSONObject root = new JSONObject( payload);
        JSONArray dataArray = root.getJSONArray("data");
        for (int t=0; t<dataArray.length(); t++) {
            JSONObject JObject = dataArray.getJSONObject(t);
            System.out.println(JObject.getString("columnname"));
        }

        String FilterData="";
        //JSONObject jsonObj=new JSONObject(payload);
        List<OatsExceptionSummary> Data =ISurveillanceService.getOatsExecptionSummary(FilterData);  
         if (Data.isEmpty()) {
                return new ResponseEntity<List<OatsExceptionSummary>>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<List<OatsExceptionSummary>>(Data, HttpStatus.OK);
            }
     }