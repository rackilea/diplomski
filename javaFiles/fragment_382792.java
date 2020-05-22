List<AcceptBean> list = new ArrayList<AcceptBean>();

PreparedStatement prest = (PreparedStatement) conn.prepareStatement(occQuery);
ResultSet rs = prest.executeQuery();
while (rs.next()) {
    AcceptBean bean = new AcceptBean();
    bean.setFirstName(rs.getString("FirstName"));
    bean.setLastName(rs.getString("LastName"));
    bean.setVillage(rs.getString("Village"));
    bean.setSonOf(rs.getString("SonOf"));
    bean.setDistrict(rs.getString("District"));
    list.add(bean);
}

request.setAttribute("list1", list);