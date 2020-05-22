@SMDMethod
public HashMap<String,String> someMethod() {
    IGenericDAO dao = (IGenericDAO) ActionContext.getContext().get("contextDao");
    //dao's deletes, updates that i want to rollback
    HashMap<String,String> x = null;
    x.put("x","x"); //<---- NPE!
    dao.commit();   //<---- COMMIT!
    return null;
}