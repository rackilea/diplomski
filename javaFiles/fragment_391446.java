List<MyBean> lst = new ArrayList<MyBean>();
MyBean myBean;
while (rs.next()) {
          myBean = new MyBean();
          myBean.setModel(rs.getString("model"));
          ....
          lst.add(myBean);
}
.....

return lst;