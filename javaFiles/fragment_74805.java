List<String> inst=null;
try {
            DisplayInstance.authentication(accessKey, secretKey);
            inst = DisplayInstance.describeAllInstances(); 
     } catch (Exception e)
         {
            e.printStackTrace();
         }
        PrintWriter out = response.getWriter();
        out.println(inst);