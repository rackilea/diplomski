@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public  Response addEmployee(@RequestBody UserInputModel userInputModel,
            JSONObject json) {
        Response result;
        try { 
               String pv_user_email_id = "";
                if(json.has("pv_user_email_id")){
                    pv_user_email_id = json.getString("pv_user_email_id");
                }  

              Integer id =0;
              if(json.has("id")){
                    id = json.getInt("id");
                }

              userInputModel.setUser_email_id(pv_user_email_id);
              userInputModel.setId(id);

            result = dataServices.addEntity(userInputModel);            
            return result;
        } catch (Exception e) {
            e.printStackTrace();            
            return null;
        }

    }