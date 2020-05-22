while(rs.next()){
        item = new Item();
        item.setId(rs.getInt(1));
        item.setDescription(rs.getString(2));
        item.setWeight(rs.getFloat(3));
        item.setPrice(rs.getFloat(4));
        item.setManufacturingDate(rs.getDate(5));
        item.setUseBeforeMonths(rs.getInt(6));

        list.add(item);
    }

    rs=st.executeQuery(milk_query);
    while(rs.next()){
        item = new Item();
        item.setId(rs.getInt(1));
        item.setDescription(rs.getString(2));
        item.setWeight(rs.getFloat(3));
        item.setPrice(rs.getFloat(4));
        item.setManufacturingDate(rs.getDate(5));
        item.setUseBeforeMonths(rs.getInt(6));

        list.add(item);
    }

    rs=st.executeQuery(wheat_query);
    while(rs.next()){
        item = new Item();
        item.setId(rs.getInt(1));
        item.setDescription(rs.getString(2));
        item.setWeight(rs.getFloat(3));
        item.setPrice(rs.getFloat(4));
        item.setManufacturingDate(rs.getDate(5));
        item.setUseBeforeMonths(rs.getInt(6));

        list.add(item); 
    }