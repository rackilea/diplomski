public ActionForward getTransactionsByStatus(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
                    throws Exception
    {   
       Person p = (Person) form;
       System.out.println("Testing************************"+p.getTestString());
       return null;
     }