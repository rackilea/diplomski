List<MyBean> list = new ArrayList<MyBean>();
for(int i=0; ;i++) {
    String recNo = request.getParameter("recordNo"+i);
    if(recNo == null) break;
    MyBean bean = new MyBean();
    bean.setRecordNo(recNo);
    bean.setDob(request.getParameter("dob"+i));
    // etc
}