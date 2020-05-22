Wb wb=null;


ResultSet rs = stmt.executeQuery(query);    
            while (rs.next()) {   

                wb =new Wb();  

                wb.setDeviceAccount(rs.getString("accountID"));
                wb.setVehicleId(rs.getString("deviceID"));
                wb.setSimNumber(rs.getString("simID"));
                wb.setImeiNumber(rs.getString("imeiNumber"));
                wb.setLastTimestamp(rs.getString("lastGPSTimestamp"));
                wb.setLastLoginTime(rs.getString("lastUpdateTime"));
                wb.setExpirationTime(rs.getString("expirationTime"));
                list.add(wb);

            }