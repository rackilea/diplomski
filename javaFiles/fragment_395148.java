User u = new User();  
     u.setId(1);  
     u.setName("Jhon");  

    JSONObject obj=new JSONObject();
    obj.put("u_id",user.getId());
    obj.put("u_name",user.getName());
    out.println(json);
    out.flush();