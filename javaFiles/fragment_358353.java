if (json_pat_list != null) {

    Log.d("json_string",json_pat_list);

    //Either this

    String formattedString = json_pat_list.replaceAll("\n", "\\n");

     //or you can do this
     String formattedString = json_pat_list.substring(s.indexOf("{")); 

    try {

        JSONObject jsonObj = new JSONObject(json_pat_list);