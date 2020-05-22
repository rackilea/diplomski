List<EmployeeBean> ebList=  ArrayList<EmployeeBean>();
     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    for(int i=1;i<=5;i++){
        EmployeeBean eb = new EmployeeBean();
         eb.setEmpid(Emp_id);


         Date logindate = new java.sql.Date(formatter.parse(request.getParameter("logindate"+i)).getTime());
          eb.setLogindate((java.sql.Date) logindate);


      //String Date=request.getParameter("logindate");    
      String LoginTime=request.getParameter("logintime"+i);
      eb.setLogintime(LoginTime);
      eb.setLogouttime(request.getParameter("logouttime"+i));
       eb.setLunch(request.getParameter("lunch"+i));
       eb.setAfterlunchlogin(request.getParameter("afterlunchlogin"+i));
       eb.setAfterlunchlogout(request.getParameter("afterlunchlogout"+i));
       eb.setTask(request.getParameter("task"+i));
        eb.setTotal(request.getParameter("total"+i));
       eb.setOvertime(request.getParameter("overtime"+i));
    }
    TimeSheetDao.insert(ebList);