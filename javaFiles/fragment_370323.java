String sql = "INSERT INTO RoomInfo (RoomNumber, Reserved, RoomCategory, AirConditioned, BedType, RentPerDay) 
VALUES (?, ?, ?, ?,?)";
        ps = con.prepareStatement(sql);

        ps.setString(1, objr.roomno);
        ps.setString(2, objr.reserved);
        ps.setString(3, objr.category);
        ps.setString(4, objr.AirConditioned);
        ps.setString(5, objr.bedtype);
        ps.setString(6, objr.rent);