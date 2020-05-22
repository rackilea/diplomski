try{
   connection.setAutoCommit(false)

   //get organisation id first
   String nextOrgIdSql = "select orgSeq.nextval from someVirtualTable" //depends on database
   ResultSet orgIdRs = statement.executeQuery( nextOrgIdSql)
   int orgId = -1
   if( orgIdRs.next())    
      orgId = orgIdRs.getInt(1)

   //create organisation first
   String orgSql = 
      "Insert into ORGANISATION (ORGID, ...) values ("+ orgId + ",...)"

   //create activities
   for( Activity activity : organisation.getActivityList()){
      String nextActvIdSql = "select activitySeq.nextval from someVirtualTable"
      ResultSet actvIdRs = statement.executeQuery( nextActvIdSql)
      int actvId = -1
      if( actIdRs.next())    
         actvId = actvIdRs.getInt(1)

      statement.execute(
        "Insert INTO ACTIVITY (ACTVID, ORGID) values ("+actvId+","+orgId+")"
   }

   connection.commit()

}catch(SQLException e){
  connection.rollback()
}