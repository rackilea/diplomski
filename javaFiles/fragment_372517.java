Gson gson = new Gson();
          ResponseDTO dto = null;
          String json = "";
          response.setContentType("application/json");
          ......
          if (rs.getInt("qty") > qty) {
                dto = new ResponseDTO();
                int id = rs.getInt("item_id");
                dto.setId(id); 
                ......

                json = gson.toJson(dto);            
            } else {
               ...... // similar
                json = gson.toJson("{data: 'Some message'}");
            }
        response.getWriter().print(json);