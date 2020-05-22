CallableStatement cstmt;
ResultSet rs;
int i;
...
cstmt.execute();                            // Call the stored procedure 

    // select  @errcode,@errmsg

    rs = cstmt.getResultSet();              // Get the result set

    while (rs.next()) {                     
        // Process the resultset   

    }

    rs.close();

    // select  op_type, xyqrid, dh, yhdmc, type, qsrq, jzrq,qssj, jzsj, jsfs, oano, description, oprrq, oprsj from #head

    rs = cstmt.getResultSet();              // Get the result set

    while (rs.next()) {                     
        // Process the resultset   

    }

    rs.close();

    // select op_type,xyqrid,dh,gdsid,orgid,qdid,tjlb,pp,gys,fmid,yhed,yhsl,unit from #detail

    rs = cstmt.getResultSet();              // Get the result set

    while (rs.next()) {                     
        // Process the resultset   

    }

    rs.close();

cstmt.close();