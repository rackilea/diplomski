String dropDown1 = request.getParameter("dropDown1");
        String dropDown2 = request.getParameter("dropDown2");
        StringBuilder builder = new StringBuilder("Select * from table where ");
        if(dropDown1 !=null){
            if(dropDown1.equalsIgnoreCase("ALL")){
                builder.append("cityId IS NOT NULL");
            }else{
                builder.append("cityId="+dropDown1);
            }
        }

        if(dropDown2 !=null){
            if(dropDown2.equalsIgnoreCase("ALL")){
                builder.append("and categId IS NOT NULL");
            }else{
                builder.append("and categId="+dropDown2);
            }
        }
        String finalQuery = builder.toString();