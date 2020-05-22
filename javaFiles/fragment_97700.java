String newAddrs = "";
      JSONArray Address = (JSONArray) temp.get("Residence_address");              
      int i = 0;
      while(i < Address.size()){
              newAddrs += "ADD" + i + ( i < Address.size() - 1 ? "," : "");
              updateRequest.addScriptParam("ADD"+i, Address.get(i++));
      }
      updateRequest.script("ctx._source.Residence_address += ["+newAddrs+"]");