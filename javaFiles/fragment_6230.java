if (action.equals("delete")) { //Delete record                   
            try {   
    //first get your record id from the request parameter
      Integer recordId=Integer.parseInt(request.getParameter("reason_code")
                                                                    .toString());

                    ReasonCodeBean record = new ReasonCodeBean();
                    //set recordId in in record object
                    record.setReasonCode(recordId);
                    //also make changes in delete method(remove where condition for description)
                    daorscode.deleteReasonCode(record);
                    //Convert Java Object to Json       
                    String json = "{\"Result\":\"OK\"}";

                    //Return Json in the format required by jTable plugin
                    response.getWriter().print(json);
            } catch (Exception ex) {
                String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
                response.getWriter().print(error);
            }
        }