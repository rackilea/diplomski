String InsertQuery2 = "UPDATE TABLE Sample SET PartNumber = ? WHERE WorkOrderID = ?"
                            + "values(?,?)";                    
                myquery2 = conn.prepareStatement(InsertQuery2);
                myquery2.setString(1, partnumber);
                myquery2.setString(2, workorder);
                myquery2.execute();