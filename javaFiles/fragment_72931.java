if(functionType.equals("add")){
                // to insert in villages table
                districtPS = connection.prepareStatement("INSERT INTO m_villages(districtid,village,creation_date,last_created_by)  VALUES (?, ?, ?,?) ", 
                        Statement.RETURN_GENERATED_KEYS);
                districtPS.setInt(1, viewmodel.getDistrictid());
                districtPS.setString(2, viewmodel.getVillage());
                districtPS.setTimestamp(3, getCurrentDate());
                districtPS.setInt(4,viewmodel.getUserid());
                districtPS.executeUpdate();
                ResultSet keySet = districtPS.getGeneratedKeys();
                int villageId = 0;
                if (keySet.next()) {
                    villageId = keySet.getInt(1);
                }
                // to insert in regions table
                districtPS = connection.prepareStatement(" INSERT INTO m_regions(villageid,creation_date,last_created_by)  VALUES (?, ?, ?) ", 
                        Statement.RETURN_GENERATED_KEYS);
                districtPS.setInt(1, villageId);
                districtPS.setTimestamp(2, getCurrentDate());
                districtPS.setInt(3,viewmodel.getUserid());
                districtPS.executeUpdate();
            }