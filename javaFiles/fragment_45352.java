while(rs.next()){
        int id=rs.getInt("company_id");
        String category=rs.getString("company_name");
        Object[] itemData = new Object[] {id, category};
        cmbCategory.addItem(itemData);
    }