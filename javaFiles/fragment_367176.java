ResultSet rs=stmt.executeQuery("select to_char(nvl(max(substr(offerno,4,4)),0)+1) from offer1 where div_sec='"+cd+"'");
             if(rs.next())
                 no=rs.getString(1);
             ResultSet rs1=stmt.executeQuery("select lpad(ltrim(rtrim("+no+")),4,'0') from dual");
             if(rs1.next())
                 no=rs1.getString(1);