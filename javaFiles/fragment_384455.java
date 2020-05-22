private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // TODO add your handling code here:
    String selgame=listerine.getSelectedValue().toString();
    String qu="select filename,filepath from dosrocket where name="+"'"+selgame+"'";
    String gname=null,gpath=null;
    try{
            ras=st.executeQuery(qu);
            while(ras.next()){
                gname=ras.getString(1);
            gpath=ras.getString(2);
            }
         String cdcommand="cd C:/Program Files/DOSBox-0.74";

         CommandLine cmdinstance=CommandLine.parse(cdcommand);

    cmdinstance.addArgument("dosbox");
          cmdinstance.addArgument("mount c:"+gpath);
    cmdinstance.addArgument(gname);

    DefaultExecutor exac=new DefaultExecutor();

    int exitval2=exac.execute(cmdinstance);
    }
    catch (Exception e){
        e.printStackTrace();
    }
    try{
        ras.close();    
        st.close();
        con.close();
    }
    catch(SQLException e){
        e.printStackTrace();
    }

}