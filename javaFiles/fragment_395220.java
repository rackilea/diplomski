@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {

    String result = null;
    HttpSession session = request.getSession();
    String name = (String)session.getAttribute("username");
    int a = Integer.parseInt(name);
    CandyResume val = (CandyResume)form;
    Connection con = DBConnection.DBConnection.justConnect();
    try{            
        FormFile formFile = val.getFile();
        InputStream fin = formFile.getInputStream();
        PreparedStatement ps = con.prepareStatement("INSERT INTO seek_resumeupdate VALUES(?,?)");
        ps.setInt(1, a);
        ps.setBlob(2, fin);
        int insert = ps.executeUpdate();
        if(insert!=0)
            result = "uploaded";
        else 
            result = "failed";
    }catch(SQLException ex){
        ex.printStackTrace();
    }
    return mapping.findForward(result);
}