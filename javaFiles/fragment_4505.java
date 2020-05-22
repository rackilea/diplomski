// We must have an empty data source to make sure the layout can show up
    // otherwise will have a blank pdf file
    List<Object> emptyList = new ArrayList<Object>();
    Object nothing = null;
    emptyList.add(nothing);
    JRBeanCollectionDataSource jRBeanCollectionDataSource = new JRBeanCollectionDataSource(emptyList,false); 

    // This is declared inside the spring/jasper-views.xml
    model.put("datasource", jRBeanCollectionDataSource);
    modelAndView = new ModelAndView("pdfReport", model);