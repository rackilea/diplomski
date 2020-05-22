public String crumb(String viewName){

    ApplicationContext appContext = new ClassPathXmlApplicationContext("breadCrumb.xml");
    BreadCrumbs crumbListObj = (BreadCrumbs) appContext.getBean(viewName);

    List y = crumbListObj.getCrumbList();
    String x="";

    for (int i=0; i < y.size(); i++){

      BreadCrumbs crumbpropsObj = (BreadCrumbs) appContext.getBean("" + y.get(i) + "");
      if (x.length() > 0){x += ",";}
      x = x + "," + y.get(i) + "," + crumbpropsObj.getVaule1() + "," + crumbpropsObj.getValue2(); 

    }

    return x;

 }