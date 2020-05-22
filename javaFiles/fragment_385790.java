JSONObject jObject = null;
    try {

    String res=FileUtils.readFileToString(new File("test.txt"));        
       jObject = new JSONObject(res);
       JSONArray j1 = jObject.JSONArray ("dataset");
       System.out.println(j1);
        j2 = j1.getJSONObject("lEquations");           
       System.out.println(j2);
    } catch (Exception e) {
        System.out.println("Exception: "+e.getMessage());

    }