@RequestMapping(value = "/config/configcollectlist",method =   RequestMethod.GET)
  public Callable<String> getConfigCollectist(ModelMap model) 
  {
    Callable<String> asyncTask = new Callable<String>() {

       @Override
       public String call() throws Exception {

       Session session = sessionFactory.openSession();
       List<DbConfigCollect> configCollects = (List<DbConfigCollect>)session.createCriteria(DbConfigCollect.class).list();
       session.close();
       model.addAttribute("configCollects", configCollects);

       return "admin/config/configcollectlist"; 
     }
   };

  return asyncTask;
 }