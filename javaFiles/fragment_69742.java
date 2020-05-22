private void credentialProcessing(HttpServletRequest request,
            HttpServletResponse response) {

        try{
           algo al = new algo();
           al.callSomeMethod();
        }
         catch (ServletException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }