//add HttpServletRequest request in spring controller as parameter
   String phyPath = request.getSession().getServletContext().getRealPath("/");

   String filepath = phyPath + "resources/" + filename +".json";
   File file = new File(filepath);
   if (!file.exists()) {
            file.createNewFile();
   }