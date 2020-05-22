Query query = session.createQuery(
           "from Document d join d.tags t "+
           " where d.nPages <= :numberPages and "+
              " t.title in (:titles) "; 
  List<String> titles = new ArrayList<String>();
  titles.add("short");
  titles.add("essay");
  query.setParameter("numberPages", nPages);  
  query.setParameterList("titles", titles);