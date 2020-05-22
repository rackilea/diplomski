int u_id=0;
try{
    String u_name=(String) session.getAttribute("myses");
    ResultSet rs=Usedata.connectuserinfo(u_name); 
    if(rs!=null){
            u_id=rs.getInt(1);
            f_name=rs.getString(2);