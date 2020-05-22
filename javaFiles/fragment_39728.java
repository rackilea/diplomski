<%!
    public String autoPONo()throws SQLException{
               String POno = null;
                rs=pst.executeQuery();

                if(rs.next()){
                   String po= rs.getString("max(PONo)");
                   int intNo = Integer.parseInt(po);
                   intNo+=1;

                   POno = Integer.toString(intNo);  
                }

           return POno; 
        }
    }
%>