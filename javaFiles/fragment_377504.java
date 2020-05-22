List<MyTab> tabList = new ArrayList<>();
    while (rs.next()) {
        // I use constants or an enum to avoid typo errors
        String col1 = rs.getString(MyTab.COLUMN_1);
        String col2 = rs.getString(MyTab.COLUMN_2);
        String col3 = rs.getString(MyTab.COLUMN_3);
        tabList.add(new MyTab(col1, col2, col3));
    }