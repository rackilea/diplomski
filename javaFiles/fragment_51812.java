connect();

             try
                {     
                    String db = conn.getCatalog();
                    data.append("The current database " + db + " contains the following tables:\r\n");
                }
             catch(Exception err)
                {
                    System.out.print(err + "\r\n");
                }         

             try
                {
                    ResultSet rs = null;
                    DatabaseMetaData md = conn.getMetaData();
                    rs = md.getTables(null, null, "%", null);

                    while (rs.next()) 
                        { 
                            String tbl = rs.getString(3);
                            String query = ("SELECT COUNT(*) FROM " + tbl);   
                            PreparedStatement cnt = conn.prepareStatement(query);                         
                            ResultSet ct = cnt.executeQuery();
                            while (ct.next())
                            {
                                data.append("Table " + rs.getString(3) + " has " + ct.getString(1) + " records\r\n");
                            }  
                        }

                    data.append("\r\n");
                }

             catch(Exception err)
                {
                    System.out.print(err + "\r\n");
                }